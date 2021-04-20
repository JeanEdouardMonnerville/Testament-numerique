
package projetut.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
/*
Le but de cette classe est de désactivé l'auto-création d'une page Login crée par
springframework.security.
*/
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity security) throws Exception
    {
     security.httpBasic().disable();
     security.authorizeRequests()
                  .antMatchers("/h2-console/**").permitAll()//allow h2 console access to admins only
                  .and().csrf().ignoringAntMatchers("/h2-console/**")//don't apply CSRF protection to /h2-console
                  .and().headers().frameOptions().sameOrigin();//allow use of frame to same origin urls
    }
    
  }