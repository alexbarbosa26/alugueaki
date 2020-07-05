package com.alugueaki.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alugueaki.project.domain.Imovel;

public interface ImovelRepository extends JpaRepository<Imovel, Integer>{

}
