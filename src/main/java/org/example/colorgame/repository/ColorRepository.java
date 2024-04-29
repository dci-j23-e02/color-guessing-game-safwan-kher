package org.example.colorgame.repository;

import org.example.colorgame.model.Color;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ColorRepository extends JpaRepository<Color, Long> {

}
