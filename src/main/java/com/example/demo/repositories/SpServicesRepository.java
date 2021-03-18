package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import org.springframework.stereotype.Repository;


import com.example.demo.entities.ServiceProviders;
import com.example.demo.entities.Services;
import com.example.demo.entities.SpServices;
@Repository
public interface SpServicesRepository extends JpaRepository<SpServices, Integer>
{

	@Query("select sp.sp_id from SpServices sp where sp.service_id=:service_id")
	public List<ServiceProviders> getSpServices(Services service_id );
	
	@Query("from SpServices sp where sp.service_id=:s")
	public List<SpServices> getSpServicesList(Services s);
	
	@Query("from  SpServices sp where sp.sp_id=:sp")
	public List<SpServices> getAllSpServiceBySp_id(ServiceProviders sp);
	
	@Modifying
	@Query(value = "DELETE FROM sp_services WHERE service_id=:service",nativeQuery = true)
	public void deleteSpServicesById(Services service);
	

}
