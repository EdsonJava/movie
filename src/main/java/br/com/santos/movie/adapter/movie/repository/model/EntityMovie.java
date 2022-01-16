package br.com.santos.movie.adapter.movie.repository.model;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import br.com.santos.movie.adapter.producer.repository.model.EntityProducer;
import br.com.santos.movie.adapter.studio.repository.model.EntityStudio;
import br.com.santos.movie.domain.movie.model.Movie;
import lombok.Data;

@Data
@Entity
@Table(name="movie")
public class EntityMovie {
	
	@Id
	@GeneratedValue (strategy =  GenerationType.IDENTITY)
	private Long id;
	@Column(name="YEAR")
	private Integer year;
	@Column(name="TITLE")
	private String title;
	@Column(name="WINNER")
	private String winner;
	@ManyToMany(cascade = CascadeType.MERGE)
	@JoinTable(name="MOVIEPRODUCER",
	             joinColumns={@JoinColumn(name="MOVIE_ID")},
	             inverseJoinColumns={@JoinColumn(name="PRODUCER_ID")})
	private List<EntityProducer> producers;
	@ManyToMany(cascade = CascadeType.MERGE)
	@JoinTable(name="MOVIESTUDIO",
	             joinColumns={@JoinColumn(name="MOVIE_ID")},
	             inverseJoinColumns={@JoinColumn(name="STUDIO_ID")})
	private List<EntityStudio> studios;	
	
	
	public static EntityMovie convertToEntityMovie(Movie movie) {
		
		EntityMovie entityMovie = new EntityMovie();
		entityMovie.setId(movie.getId());
		entityMovie.setYear(movie.getYear());
		entityMovie.setTitle(movie.getTitle());
		entityMovie.setWinner(movie.getWinner());
		
		entityMovie.setProducers(movie.getProducers() == null ? null :
			movie.getProducers()
								.stream()
								.map(EntityProducer::convertToEntityProducer)
								.collect(Collectors.toList()));
		
		entityMovie.setStudios(movie.getStudios() == null ? null :
			movie.getStudios()
								.stream()
								.map(EntityStudio::convertToEntityStudio)
								.collect(Collectors.toList()));
				
		return entityMovie;
	}
	
	public Movie convertToMovie() {
		
		Movie movie = new Movie();
		movie.setId(this.getId());
		movie.setYear(this.getYear());
		movie.setTitle(this.getTitle());
		movie.setWinner(this.getWinner());
	
		movie.setProducers(this.getProducers() == null  ? null :
			this.getProducers()
						.stream()
						.map(EntityProducer::convertToProducer)
						.collect(Collectors.toList()));
		
		movie.setStudios(this.getStudios() == null ? null :
			this.getStudios()
						.stream()
						.map(EntityStudio::convertToStudio)
						.collect(Collectors.toList()));
		
		return movie;
	}

}
