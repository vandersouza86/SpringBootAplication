package com.poc.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.poc.demo.entity.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long>{

}

