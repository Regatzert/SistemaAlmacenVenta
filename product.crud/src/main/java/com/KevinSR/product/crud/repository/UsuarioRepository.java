package com.KevinSR.product.crud.repository;

import org.springframework.stereotype.Repository;

import com.KevinSR.product.crud.entity.Usuario;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

}
