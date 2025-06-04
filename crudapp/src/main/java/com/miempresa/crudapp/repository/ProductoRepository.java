package com.miempresa.crudapp.repository;

import com.miempresa.crudapp.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
}
