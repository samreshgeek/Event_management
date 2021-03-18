package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Emails;

@Repository
public interface EmailsRepository extends JpaRepository<Emails, Integer>
{

}
