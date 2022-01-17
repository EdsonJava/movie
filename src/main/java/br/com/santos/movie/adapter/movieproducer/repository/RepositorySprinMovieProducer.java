package br.com.santos.movie.adapter.movieproducer.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.santos.movie.adapter.movieproducer.repository.model.EntityMovieProducer;

@Repository
public interface RepositorySprinMovieProducer extends JpaRepository<EntityMovieProducer, Long> {

	@Query(value="select * from producer inner join movieproducer on producer.id = movieproducer.producer_id "
			+ "inner join movie on movie.id = movieproducer.movie_id "
			+ "where winner = 'yes'  and exists (select count(producer_a.id)  from producer as producer_a inner join movieproducer on producer_a.id = movieproducer.producer_id "
			+ "inner join movie as movie_a on movie_a.id = movieproducer.movie_id where producer.id = producer_a.id and  winner = 'yes'  "
			+ "group by producer_a.id "
			+ "having count(producer_a.id) > 1)",nativeQuery = true) 
	List<EntityMovieProducer> findAllWinners();	
}
