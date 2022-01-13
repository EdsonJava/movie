package br.com.santos.movie.adapter.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.santos.movie.adapter.repository.model.EntityMovie;

@Repository
public interface RepositorySprinMovie extends JpaRepository<EntityMovie, Long> {

	
	@Query(value = "select em from EntityMovie em where exists (select 1,  "
			+ "count(m.producers) from EntityMovie m "
			+ "where em.producers = m.producers and m.winner = 'yes' "
			+ "group by m.producers having count(m.producers) > 1 )")
	List<EntityMovie> listWinners();
	
}
