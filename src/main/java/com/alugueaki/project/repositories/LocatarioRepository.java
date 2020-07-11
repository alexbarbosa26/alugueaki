package com.alugueaki.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alugueaki.project.domain.Locatario;

public interface LocatarioRepository extends JpaRepository<Locatario, Integer> {

}
