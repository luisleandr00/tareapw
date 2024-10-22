package com.tareapw.service;

import com.tareapw.entity.EventsEntity;
import com.tareapw.repository.EventsRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

    @Service
    @AllArgsConstructor
    public class EventsServiceImp implements EventsService<EventsEntity, Long> {
        private final EventsRepository eventsRepository;

        @Override
        public List<EventsEntity> getAll() {
            return eventsRepository.findAll();
        }

        @Override
        public EventsEntity getById(Long id) {
            return eventsRepository.findById(id)
                    .orElseThrow(() -> new EntityNotFoundException("Event not found!"));
        }

        @Override
        public void create(EventsEntity eventEntity) {
            eventsRepository.save(eventEntity);
        }

        @Override
        public void update(Long id, EventsEntity eventEntity) {
            EventsEntity eventDB = eventsRepository.findById(id)
                    .orElseThrow(() -> new EntityNotFoundException("Event not found!"));
            eventDB.setName(eventEntity.getName());
            eventDB.setDate(eventEntity.getDate());
            eventsRepository.save(eventDB);
        }

        @Override
        public void delete(Long id) {
            eventsRepository.deleteById(id);
        }
    }

