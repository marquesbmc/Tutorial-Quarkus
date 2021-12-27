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
	
	public long divZero(Long z ) throws Exception  {
		return z/0;
	}
	

	public List<Client> listAll() throws Exception  {
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

	public Client updateById(Long id, Client client) throws Exception  {
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
