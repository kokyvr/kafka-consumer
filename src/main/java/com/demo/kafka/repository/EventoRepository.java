package com.demo.kafka.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.kafka.entity.Evento;

public interface EventoRepository extends JpaRepository<Evento, Long> {
    
}
