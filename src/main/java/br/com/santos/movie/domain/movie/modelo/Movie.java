package br.com.santos.movie.domain.movie.modelo;

import java.util.Objects;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Movie {


	private Long id;
	private Integer year;
	private String title;
	private String studios;
	private String producers;
	private String winner;
	
	
	@Override
	public int hashCode() {
		return Objects.hash(producers);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Movie other = (Movie) obj;
		return Objects.equals(producers, other.producers);
	}
	
	
	
}
