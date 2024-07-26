package br.com.cammac.retomandoTreinamentoSpringBoot.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosSerie(@JsonAlias("Title")  String titulo,
						 @JsonAlias("totalSeasons") Integer totalTemporadas,
						 @JsonAlias("imdbRating") String avaliacao) {

}
