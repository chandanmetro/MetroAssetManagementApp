package com.metro.app.metro.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.metro.app.metro.application.entity.Device;

@Repository
public interface DeviceRepository extends JpaRepository<Device, String> {

}
