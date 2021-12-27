package com.github.marquesbmc.service;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import com.github.marquesbmc.model.entities.Operacao;
import com.github.marquesbmc.repository.OperacaoRepository;

@ApplicationScoped
public class OperacaoService {

	@Inject
	OperacaoRepository operacaoRepository;

	public List<Operacao> listaUf() {
		return operacaoRepository.findByFederacao();
	}

}
