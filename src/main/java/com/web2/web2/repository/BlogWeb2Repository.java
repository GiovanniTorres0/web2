package com.web2.web2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.web2.web2.modelo.Postagens;

public interface BlogWeb2Repository extends JpaRepository<Postagens, Long> {

}
