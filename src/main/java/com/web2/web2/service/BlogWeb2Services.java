package com.web2.web2.service;

import java.util.List;

import com.web2.web2.modelo.Postagens;

public interface BlogWeb2Services {
	List<Postagens> findAll();
	Postagens save(Postagens postagem);
	Postagens findById(Long id);
}
