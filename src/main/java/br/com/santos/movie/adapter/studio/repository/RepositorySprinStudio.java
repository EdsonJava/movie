package br.com.santos.movie.adapter.studio.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.santos.movie.adapter.studio.repository.model.EntityStudio;

@Repository
public interface RepositorySprinStudio extends JpaRepository<EntityStudio, Long>  {

	@Query(value = "select s from EntityStudio s where s.name = ?1 ")
	Optional<EntityStudio> findByName(String name);
}
