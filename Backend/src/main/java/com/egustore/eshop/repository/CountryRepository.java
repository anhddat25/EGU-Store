package com.egustore.eshop.repository;

import com.egustore.eshop.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Integer> {
}
