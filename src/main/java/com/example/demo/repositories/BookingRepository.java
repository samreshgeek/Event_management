package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entities.Booking;
import com.example.demo.entities.Consumers;
import com.example.demo.entities.ServiceProviders;

public interface BookingRepository  extends JpaRepository<Booking, Integer>
{
	@Query("from Booking b where b.c_id=:c_id")
	public List<Booking> getBookingByConsumerId(Consumers c_id);
	
	//@Query("delete from Booking b where b.b_id=:b_id")
	@Modifying
	@Query(value = "DELETE FROM booking WHERE b_id=?1",nativeQuery = true)
	public void deleteConsumerBookingById(int b_id);
	
	@Query("from Booking b where b.sp_id=:sp")
	public List<Booking> getBookingByServiceProviderById(ServiceProviders sp);
}
