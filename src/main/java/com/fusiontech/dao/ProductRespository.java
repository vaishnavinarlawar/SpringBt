package com.fusiontech.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fusiontech.dto.Product;

@Repository
public interface ProductRespository extends JpaRepository<Product, Integer> {
List<Product>findByStatus(String status);
}
