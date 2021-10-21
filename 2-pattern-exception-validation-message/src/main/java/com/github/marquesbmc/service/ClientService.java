package com.github.marquesbmc.service;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import javax.ws.rs.NotFoundException;

import com.github.marquesbmc.model.Client;
import com.github.marquesbmc.repository.IClientRepository;

@ApplicationScoped
public class ClientService {

	@Inject
	private IClientRepository clientRepository;

	public Boolean test() {
		try {
			return clientRepository.testar();
		} catch (NotFoundException e) {
			return null;
		}
	}

	public List<Client> listAll() throws Throwable {
		try {
			return clientRepository.listAll();
		} catch (NotFoundException e) {
			return null;
		}
	}

	public Client findBy(Long id) throws Throwable {

		return clientRepository.findById(id);

	}

	public List<Client> findByName(String name) throws Throwable {

		return clientRepository.findByName(name);

	}

	public Client post(Client client) throws Exception {

		clientRepository.persist(client);
		return client;

	}

	public Client updateById(Long id, Client client) throws Throwable {
		try {
			Client c = clientRepository.findById(id);
			if (c == null) {
				throw new NotFoundException();
			} else {
				c.setName(client.getName());
				c.setBalance(client.getBalance());
				c.setBirthDate(client.getBirthDate());
			}
			return c;
		} catch (NotFoundException e) {
			return null;
		}
	}

	public String deleteById(Long id) throws Throwable {

		Boolean deleted = clientRepository.deleteById(id);

		if (deleted) {
			return "Item excluído";
		} else {
			return "Id não encontrado";
		}

	}

	public boolean isPersistent(Client c) throws Throwable {
		return clientRepository.isPersistent(c);
	}

}
