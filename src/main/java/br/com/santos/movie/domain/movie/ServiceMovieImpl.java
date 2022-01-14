package br.com.santos.movie.domain.movie;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import br.com.santos.movie.domain.movie.model.Movie;
import br.com.santos.movie.domain.movie.model.MovieWinner;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ServiceMovieImpl implements ServiceMovie {

	private final RepositoryMovie repositoryMovie;

	@Override
	public void insert(List<Movie> list) {
	
		repositoryMovie.insert(list);
	}

	@Override
	public List<MovieWinner> listWinners() {
			
		var list = repositoryMovie.listWinners();
		var listAll = mountListMovieWinner(list);	
		listAll.sort(Comparator.comparing(MovieWinner::getInterval));
	
		return listAll;
	}

	private List<MovieWinner>  maxInterval(List<MovieWinner> listAll) {

		return listAll.stream().max(Comparator.comparing(MovieWinner::getInterval))
				.map(max ->
					 listAll
							.stream()
							.filter(mov -> mov.getInterval().equals(max.getInterval()))
							.collect(Collectors.toList())
				).orElse(List.of());

	}

	private List<MovieWinner>  minInterval(List<MovieWinner> listAll) {


		return listAll.stream().min(Comparator.comparing(MovieWinner::getInterval))
				.map(min ->
						listAll
								.stream()
								.filter(mov -> mov.getInterval().equals(min.getInterval()))
								.collect(Collectors.toList())
				).orElse(List.of());
	}

	private List<MovieWinner> mountListMovieWinner(List<Movie> list) {
		
		var listWinner = new HashSet<>(list);
		var listMovieWinner = new ArrayList<MovieWinner>();

		if(!listWinner.isEmpty()) {
			Comparator<Movie> comparator = Comparator.comparing( Movie::getYear);
			listWinner.forEach( w -> {
				var moviesWinners = list
									.stream()
									.filter(producer -> producer.getProducers().equals(w.getProducers()))
									.collect(Collectors.toList());

				var minMovie = moviesWinners.stream().min(comparator);
				var maxMovie = moviesWinners.stream().max(comparator);
			
				MovieWinner mw = new MovieWinner();
				if(minMovie.isPresent()) {
					mw.setProducer(w.getProducers());	
					mw.setPreviousWin(minMovie.get().getYear());
					mw.setFollowingWin(maxMovie.get().getYear());
					mw.setInterval(maxMovie.get().getYear() - minMovie.get().getYear());
					
					if(mw.getInterval() >= 1 || mw.getInterval() <=99)  {
						listMovieWinner.add(mw);
					}
				}
			});
		}
		return listMovieWinner;
	}

	@Override
	public List<MovieWinner> listWinnerMin(List<MovieWinner> list) {

		return minInterval(list);
	}

	@Override
	public List<MovieWinner> listWinnerMax(List<MovieWinner> list) {

		return maxInterval(list);
	}
}
