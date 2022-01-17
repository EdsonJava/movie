package br.com.santos.movie.adapter.producer.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.santos.movie.adapter.producer.repository.model.EntityProducer;

@Repository
public interface RepositorySprinProducer extends JpaRepository<EntityProducer, Long> { 
	
	@Query(value = "select p from EntityProducer p where p.name = ?1 ")
	Optional<EntityProducer> findByName(String name);
	
}
