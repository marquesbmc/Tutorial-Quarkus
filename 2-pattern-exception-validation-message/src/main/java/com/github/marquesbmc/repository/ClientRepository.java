package com.github.marquesbmc.repository;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import com.github.marquesbmc.model.Client;

import io.quarkus.hibernate.orm.panache.PanacheQuery;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class ClientRepository  implements IClientRepository, PanacheRepository<Client> {

	private ClientRepository clientRepository;

	public Boolean testar() {

		return clientRepository.isPersistent(null);
	}

	@Override
	public List<Client> findByName(String name) {
		return list("SELECT c FROM Client c WHERE c.name = ?1 ORDER BY id DESC", name);
	}









}
