package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Feedback;
import com.example.demo.entities.ServiceProviders;

@Repository
public interface FeedbackRepository extends JpaRepository<Feedback, Integer>
{
	@Query("FROM Feedback f WHERE f.sp_id=:sp")
	List<Feedback> getFeedbacBySpId(ServiceProviders sp);

}
