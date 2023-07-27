package com.metro.app.metro.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.metro.app.metro.application.entity.Server;

@Repository
public interface ServerRepository extends JpaRepository<Server, String> {
	
	boolean existsBySerialNumber(String serialNumber);

}
