package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.ServiceProviders;

public interface ServiceProvidersRepository extends JpaRepository<ServiceProviders, Integer>
{

}
