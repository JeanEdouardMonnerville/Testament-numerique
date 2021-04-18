package projetut;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@EnableWebSecurity // Autorise les annotations de sécurité sur les contrôleurs
@EnableGlobalMethodSecurity(securedEnabled = true)
@Slf4j
public class WebApp {

	public static void main(String[] args) {
		SpringApplication.run(WebApp.class, args);
	}
}
