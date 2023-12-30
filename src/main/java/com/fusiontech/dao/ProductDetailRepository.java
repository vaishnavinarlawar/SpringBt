package com.fusiontech.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fusiontech.dto.ProductDetails;

@Repository
public interface ProductDetailRepository extends JpaRepository<ProductDetails, Integer>{
	
}
