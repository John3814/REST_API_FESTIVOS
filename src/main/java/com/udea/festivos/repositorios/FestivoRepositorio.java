package com.udea.festivos.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.udea.festivos.entidades.Festivo;

@Repository
public interface FestivoRepositorio extends JpaRepository<Festivo, Integer> {
    
}
