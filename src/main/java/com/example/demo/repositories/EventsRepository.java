package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Events;

public interface EventsRepository  extends JpaRepository<Events, Integer>
{

}
