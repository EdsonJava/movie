package br.com.santos.movie.adapter.movieproducer.repository.model;

import java.io.Serializable;

import javax.persistence.Column;

import lombok.Data;

@Data
public class EntityMovieProducerID implements Serializable {

	private static final long serialVersionUID = 1L;
	@Column(name="MOVIE_ID")
	private Long movie;
	@Column(name="PRODUCER_ID")
	private Long producer;

}
