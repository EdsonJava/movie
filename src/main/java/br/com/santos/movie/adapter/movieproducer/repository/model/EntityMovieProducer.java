package br.com.santos.movie.adapter.movieproducer.repository.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.santos.movie.adapter.movie.repository.model.EntityMovie;
import br.com.santos.movie.adapter.producer.repository.model.EntityProducer;
import br.com.santos.movie.domain.movieproducer.model.MovieProducer;
import lombok.Data;

@Entity
@Table(name="movieproducer")
@Data
public class EntityMovieProducer {


	@EmbeddedId
	private EntityMovieProducerID id;
	@ManyToOne
	@JoinColumn(name="MOVIE_ID", insertable=false, updatable=false)
	private EntityMovie movie;
	@ManyToOne
	@JoinColumn(name="PRODUCER_ID", insertable=false, updatable=false)
	private EntityProducer producer;
	
	public static EntityMovieProducer convertToEntityMovie(MovieProducer movieProducer) {
		
		EntityMovieProducer entityMovieProducer = new EntityMovieProducer();
		entityMovieProducer.setMovie(EntityMovie.convertToEntityMovie(movieProducer.getMovie()));
		entityMovieProducer.setProducer(EntityProducer.convertToEntityProducer(movieProducer.getProducer()));

		return entityMovieProducer;
	}
	
	public MovieProducer convertToMovieProducer() {
		
		MovieProducer movieProducer = new MovieProducer();
		movieProducer.setMovie(this.getMovie().convertToMovie());
		movieProducer.setProducer(this.getProducer().convertToProducer());

		return movieProducer;
	}


}
