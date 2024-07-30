package br.com.cammac.retomandoTreinamentoSpringBoot.principal;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import br.com.cammac.retomandoTreinamentoSpringBoot.model.DadosEpisodio;
import br.com.cammac.retomandoTreinamentoSpringBoot.model.DadosSerie;
import br.com.cammac.retomandoTreinamentoSpringBoot.model.DadosTemporada;
import br.com.cammac.retomandoTreinamentoSpringBoot.service.ConsumoApi;
import br.com.cammac.retomandoTreinamentoSpringBoot.service.ConvertDados;

public class Principal {
	
	private final String ENDERECO = "https://www.omdbapi.com/?t=";
	private final String API_KEY  = "&apikey=6585022c";

	private Scanner leitura = new Scanner(System.in);
	private ConsumoApi consumo = new ConsumoApi();
	private ConvertDados conversor = new ConvertDados();
	
	public void exibeMenu() {
		
		System.out.println("Digite o nome da série para busca");
		var nomeSerie = leitura.nextLine();
		var json = consumo.obterDados( ENDERECO + nomeSerie.replace(" ", "+") + API_KEY);
		
		DadosSerie dados = conversor.obterDados(json, DadosSerie.class);
		
		System.out.println(dados);
				
		List<DadosTemporada> temporadas = new ArrayList<>();		
		for (int pos = 1 ; pos <= dados.totalTemporadas() ; pos++) {
			json = consumo.obterDados(ENDERECO + nomeSerie.replace(" ", "+") + "&season=" + pos + API_KEY);
			DadosTemporada dadosTemporada = conversor.obterDados(json, DadosTemporada.class);
			temporadas.add(dadosTemporada);
		}
		
		temporadas.forEach(System.out::println);		
		temporadas.forEach(t->t.episodios().forEach(e -> System.out.println(e.titulo())));		
		List<DadosEpisodio> dadosEpisodios = temporadas.stream()
													   .flatMap(t->t.episodios().stream())
													   .collect(Collectors.toList());
		
		System.out.println("Top 5 episodios:");
		dadosEpisodios.stream()
			.filter(e -> !e.avaliacao().equalsIgnoreCase("N/A"))
			.sorted(Comparator.comparing(DadosEpisodio::avaliacao).reversed())
			.limit(5)
			.forEach(System.out::println);		
	}

}
