package com.prueba.demo.Model.Repository;

import com.prueba.demo.Model.Entity.Phones;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhonesRepository extends JpaRepository<Phones, String> {
}
