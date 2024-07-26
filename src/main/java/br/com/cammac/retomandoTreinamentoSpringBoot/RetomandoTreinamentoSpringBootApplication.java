package br.com.cammac.retomandoTreinamentoSpringBoot;

import br.com.cammac.retomandoTreinamentoSpringBoot.model.DadosSerie;
import br.com.cammac.retomandoTreinamentoSpringBoot.service.ConsumoApi;
import br.com.cammac.retomandoTreinamentoSpringBoot.service.ConvertDados;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RetomandoTreinamentoSpringBootApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(RetomandoTreinamentoSpringBootApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Retomando o curso de SpringBoot....");
		var consumoApi = new ConsumoApi();
		var json = consumoApi.obterDados("https://www.omdbapi.com/?t=gilmore+girls&apikey=6585022c");
		System.out.println(json);
		
		ConvertDados conversor = new ConvertDados();
		
		DadosSerie dados = conversor.obterDados(json, DadosSerie.class);
		
		System.out.println(dados);
		
	}
}
