package com.KevinSR.product.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.KevinSR.product.crud.entity.Venta;

@Repository
public interface VentaRepository extends JpaRepository<Venta, Integer>{
    
}
