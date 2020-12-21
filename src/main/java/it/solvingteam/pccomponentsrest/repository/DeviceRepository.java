package it.solvingteam.pccomponentsrest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import it.solvingteam.pccomponentsrest.model.Device;

public interface DeviceRepository extends JpaRepository<Device, Long> {

	//listAll dei componenti del pc
	List<Device> findAll();
}
