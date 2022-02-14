package com.web2.web2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web2.web2.modelo.Postagens;
import com.web2.web2.repository.BlogWeb2Repository;

@Service
public class BlogWeb2Impl implements BlogWeb2Services {

	@Autowired
	BlogWeb2Repository BlogWeb2Repository;

	@Override
	public List<Postagens> findAll() {
		return BlogWeb2Repository.findAll();
	}

	@Override
	public Postagens findById(Long id) {
		return BlogWeb2Repository.findById(id).get();
	}

	@Override
	public Postagens save(Postagens postagem) {
		return BlogWeb2Repository.save(postagem);
	}

}
