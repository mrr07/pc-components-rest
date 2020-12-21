package it.solvingteam.pccomponentsrest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import it.solvingteam.pccomponentsrest.model.Pc;

public interface PcRepository extends JpaRepository<Pc, Long> {

	//listAll dei pc
	List<Pc> findAll();
}
