package com.github.marquesbmc.service;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import com.github.marquesbmc.model.h2test.Client;
import com.github.marquesbmc.repository.IClientRepository;

@ApplicationScoped
public class ClientService {

	@Inject
	private IClientRepository clientRepository;

	public List<Client> listAll() throws Exception {
		return clientRepository.listAll();
	}

	public Client findBy(Long id) throws Exception {
		return clientRepository.findById(id);
	}

	public List<Client> procurarNome(String name) throws Exception {
		return clientRepository.procurarNome(name);
	}

	public Client post(Client client) throws Exception {
		clientRepository.persist(client);
		return client;
	}

	public Client updateById(Long id, Client client) throws Exception {

		Client c = clientRepository.findById(id);
		if (c != null) {
			c.setName(client.getName());
			c.setBalance(client.getBalance());
			c.setBirthDate(client.getBirthDate());
		}
		return c;
	}

	public String deleteById(Long id) throws Exception {
		if (clientRepository.deleteById(id)) {
			return "Item excluído";
		} else {
			return "Id não encontrado";
		}
	}

	public boolean isPersistent(Client c) throws Exception {
		return clientRepository.isPersistent(c);
	}

}
