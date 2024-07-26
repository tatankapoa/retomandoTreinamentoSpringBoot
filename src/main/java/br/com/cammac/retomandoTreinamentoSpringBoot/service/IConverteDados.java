package br.com.cammac.retomandoTreinamentoSpringBoot.service;

public interface IConverteDados {
	
	<T> T obterDados(String json, Class<T> classe);

}
