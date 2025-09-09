package com.demo.kafka.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.demo.kafka.entity.Evento;
import com.demo.kafka.repository.EventoRepository;

@Service
public class KafkaConsumerServiceImpl implements KafkaConsumerService {

    private final EventoRepository eventoRepository;

    public KafkaConsumerServiceImpl(EventoRepository eventoRepository) {
        this.eventoRepository = eventoRepository;
    }
    @Override
    @KafkaListener(topics = "${app.topic.name}", groupId = "grupo1")
    public void listen(String mensaje) {
        Evento evento = new Evento();
        evento.setContent(mensaje);
        eventoRepository.save(evento);
        System.out.println("Evento guardado: " + mensaje);
    }

}
