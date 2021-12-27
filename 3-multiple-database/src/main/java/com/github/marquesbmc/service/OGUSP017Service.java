package com.github.marquesbmc.service;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import com.github.marquesbmc.model.storeprocedures.DadosNotaEmpenhoOGUSP017;
import com.github.marquesbmc.repository.OGUSP017Repository;

@ApplicationScoped
public class OGUSP017Service {
	
	@Inject
	OGUSP017Repository OGUSP017Repository;
	
	public List<DadosNotaEmpenhoOGUSP017> listaTeste(Long num) {
		List<DadosNotaEmpenhoOGUSP017> lista = OGUSP017Repository.getListaTeste(num);
		return lista;
	}

}
