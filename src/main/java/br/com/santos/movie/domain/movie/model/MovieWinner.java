package br.com.santos.movie.domain.movie.model;

import lombok.Data;

@Data
public class MovieWinner {

	private String producer;
	private Integer interval;
	private Integer previousWin;
	private Integer followingWin;
}
