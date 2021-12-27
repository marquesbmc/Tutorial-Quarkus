package com.github.marquesbmc.repository;

import java.util.List;
import javax.enterprise.context.ApplicationScoped;

import com.github.marquesbmc.model.entities.Operacao;

import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class OperacaoRepository implements PanacheRepository<Operacao> {


	public List<Operacao> findByFederacao() {
		return find("SELECT distinct(operacao.uf) FROM Operacao operacao").list();
		

	}

}
