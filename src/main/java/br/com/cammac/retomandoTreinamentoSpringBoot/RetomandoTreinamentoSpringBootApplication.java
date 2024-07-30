package br.com.cammac.retomandoTreinamentoSpringBoot;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.cammac.retomandoTreinamentoSpringBoot.principal.Principal;

@SpringBootApplication
public class RetomandoTreinamentoSpringBootApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(RetomandoTreinamentoSpringBootApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Principal principal = new Principal();
		principal.exibeMenu();

	}
}
