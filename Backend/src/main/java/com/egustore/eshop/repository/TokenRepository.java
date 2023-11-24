package com.egustore.eshop.repository;

import com.egustore.eshop.model.Tokens;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TokenRepository extends JpaRepository<Tokens, Integer> {
}
