package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Services;

public interface ServicesRepository extends JpaRepository<Services, Integer>
{

}
