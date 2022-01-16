package br.com.santos.movie.adapter.movie.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.santos.movie.adapter.movie.repository.model.EntityMovie;


@Repository
public interface RepositorySprinMovie extends JpaRepository<EntityMovie, Long> {

	
	
}
