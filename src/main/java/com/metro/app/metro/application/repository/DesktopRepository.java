package com.metro.app.metro.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.metro.app.metro.application.entity.Desktop;

@Repository
public interface DesktopRepository extends JpaRepository<Desktop, String> {
	boolean existsBySerialNumber(String serialNumber);

}
