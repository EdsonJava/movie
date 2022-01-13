package br.com.santos.movie.domain.movie.modelo;

import lombok.Data;

@Data
public class MovieWinner {

	private String producer;
	private Integer interval;
	private Integer previousWin;
	private Integer followingWin;
}
