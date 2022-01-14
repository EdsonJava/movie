package br.com.santos.movie.adapter.movie.repository.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.modelmapper.ModelMapper;

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
	@Column(name="STUDIOS")
	private String studios;
	@Column(name="PRODUCERS")
	private String producers;
	@Column(name="WINNER")
	private String winner;
	
	public static EntityMovie convertToEntityMovie(Movie filme) {
		return new ModelMapper().map(filme, EntityMovie.class);
	}
	
	public Movie convertToMovie() {
		return new ModelMapper().map(this, Movie.class);
	}

}
