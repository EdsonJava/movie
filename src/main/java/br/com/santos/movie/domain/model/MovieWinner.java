package br.com.santos.movie.domain.model;

import lombok.Data;

@Data
public class MovieWinner {

	private String producer;
	private Integer interval;
	private Integer previousWin;
	private Integer followingWin;
}
