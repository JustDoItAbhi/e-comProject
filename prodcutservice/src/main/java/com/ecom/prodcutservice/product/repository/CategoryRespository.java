package com.ecom.prodcutservice.product.repository;

import com.ecom.prodcutservice.entity.Categoryes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRespository extends JpaRepository<Categoryes,Long> {
}
