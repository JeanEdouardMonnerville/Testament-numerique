package projetut.config;

import javax.inject.Inject;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.social.connect.ConnectionFactoryLocator;
import org.springframework.social.connect.support.ConnectionFactoryRegistry;
import org.springframework.social.linkedin.connect.LinkedInConnectionFactory;

import lombok.extern.slf4j.Slf4j;

import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.core.env.Environment;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.encrypt.Encryptors;
import org.springframework.security.crypto.encrypt.TextEncryptor;
import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.connect.UsersConnectionRepository;
import org.springframework.social.connect.jdbc.JdbcUsersConnectionRepository;
import org.springframework.social.connect.web.ConnectController;

/*
Social config paramètre avant tout des Bean. Principalement, les beans des api et connect.
*/
@Slf4j
@Configuration
public class SocialConfig {

    @Value("${spring.social.linkedin.consumerKey}")
    String clientId;
    @Value("${spring.social.linkedin.consumerSecret}")
    String clientSecret;
    @Value("${spring.social.linkedin.scope}")
    String scope;

    @Bean
    public ConnectionFactoryLocator connectionFactoryLocator() {
        ConnectionFactoryRegistry registry = new ConnectionFactoryRegistry();
        LinkedInConnectionFactory lfactory = new LinkedInConnectionFactory(clientId, clientSecret);

        lfactory.setScope(scope);
        registry.addConnectionFactory(lfactory);

        return registry;
    }

    @Bean
    @Scope(value = "request", proxyMode = ScopedProxyMode.INTERFACES)
    public ConnectionRepository connectionRepository() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null) {
            throw new IllegalStateException("Unable to get a ConnectionRepository: no user signed in");
        }
        return usersConnectionRepository().createConnectionRepository(authentication.getName());
    }

    @Inject
    private DataSource dataSource;

    @Inject
    private TextEncryptor textEncryptor;

    @Bean
    public UsersConnectionRepository usersConnectionRepository() {
        return new JdbcUsersConnectionRepository(dataSource, connectionFactoryLocator(),
                textEncryptor);
    }

    @Bean
    public TextEncryptor textEncryptor() {
        return Encryptors.noOpText();
    }

    @Configuration
    @Profile("prod")
    static class Prod {

        @Bean
        public TextEncryptor textEncryptor() {
            return Encryptors.queryableText(environment.getProperty("security.encryptPassword"), environment.getProperty("security.encryptSalt"));
        }

        @Inject
        private Environment environment;

    }

    @Configuration
    @Profile("dev")
    static class Dev {

        @Bean
        public TextEncryptor textEncryptor() {
            return Encryptors.noOpText();
        }

    }

    //ConnectController prend en charge les flux d’autorisation pour OAuth 1 et OAuth 2
    @Bean
    public ConnectController connectController() {
        return new ConnectController(connectionFactoryLocator(),
                connectionRepository());
    }

}
