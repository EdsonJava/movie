package br.com.santos.filme.adapter.controller.model;

import org.modelmapper.ModelMapper;

import br.com.santos.filme.domain.model.Movie;
import br.com.santos.filme.domain.model.MovieWinner;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MovieDTO {

	private String producer;
	private Integer interval;
	private Integer previousWin;
	private Integer followingWin;

	public static MovieDTO criar(MovieWinner movieWinner) {
		return MovieDTO.builder()
				.producer(movieWinner.getProducer())
				.interval(movieWinner.getInterval())
				.previousWin(movieWinner.getPreviousWin())
				.followingWin(movieWinner.getFollowingWin())
				.build();
	}
	
	public Movie convertToMovie() {	
		return new ModelMapper().map(this, Movie.class);
	}
}
	
	
