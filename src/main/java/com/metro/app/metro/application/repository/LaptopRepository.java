package com.metro.app.metro.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.metro.app.metro.application.entity.Laptop;


@Repository
public interface LaptopRepository extends JpaRepository<Laptop, String> {

	boolean existsBySerialNumber(String serialNumber);

}
