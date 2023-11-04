package com.example.onlinecourses.listeners;

import jakarta.annotation.PostConstruct;
import jakarta.persistence.EntityManagerFactory;
import lombok.RequiredArgsConstructor;
import org.hibernate.event.service.spi.EventListenerRegistry;
import org.hibernate.event.spi.EventType;
import org.hibernate.internal.SessionFactoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


    @RequiredArgsConstructor
    @Service
    public class HibernateListener {

        private final EntityManagerFactory entityManagerFactory;
        @Autowired
        private PersonPreInsertListener personPreInsertListener;

        @PostConstruct
        private void init() {
            SessionFactoryImpl sessionFactory = entityManagerFactory.unwrap(SessionFactoryImpl.class);
            EventListenerRegistry registry = sessionFactory.getServiceRegistry().getService(EventListenerRegistry.class);
            registry.getEventListenerGroup(EventType.PRE_INSERT).appendListener(personPreInsertListener);
        }
}