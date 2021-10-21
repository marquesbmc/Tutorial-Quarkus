package com.github.marquesbmc.repository;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import com.github.marquesbmc.model.Client;

import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public interface IClientRepository extends PanacheRepository<Client>{
	
	 public Boolean testar();
     
	 public List<Client> findByName(String name);


}