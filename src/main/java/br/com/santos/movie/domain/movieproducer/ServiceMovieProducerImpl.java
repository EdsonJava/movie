package br.com.santos.movie.domain.movieproducer;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import br.com.santos.movie.domain.movie.model.MovieWinner;
import br.com.santos.movie.domain.movieproducer.model.MovieProducer;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ServiceMovieProducerImpl implements ServiceMovierProducer {

	RepositoryMovieProducer repositoryMovieProducer;
	
	@Override
	public List<MovieWinner> findAllWinners() {

		var list = repositoryMovieProducer.findAllWinners();
		var listAll = mountListMovieProducerWinner(list);
		listAll.sort(Comparator.comparing(MovieWinner::getInterval));

		return listAll;
	}

	private List<MovieWinner> mountListMovieProducerWinner(List<MovieProducer> list) {

		var listWinner = new HashSet<>(list);
		var listMovieWinner = new ArrayList<MovieWinner>();

		if (!listWinner.isEmpty()) {
			Comparator<MovieProducer> comparator = Comparator.comparing(MovieProducer::getYear);
			listWinner.forEach( w -> {
					var moviesWinners = list
											.stream()
											.filter(p -> p.getProducer().equals(w.getProducer()))
											.collect(Collectors.toList());

				var minMovie = moviesWinners.stream().min(comparator);
				var maxMovie = moviesWinners.stream().max(comparator);

				MovieWinner winner = createMovieWinner(w, minMovie, maxMovie);
				listMovieWinner.add(winner);
			});
		}
		return listMovieWinner;
	}

	private MovieWinner createMovieWinner(MovieProducer w, Optional<MovieProducer> minMovie,
			Optional<MovieProducer> maxMovie) {
			 
		MovieWinner mw = new MovieWinner();
		if (minMovie.isPresent()) {
			mw.setProducer(w.getProducer().getName());
			mw.setPreviousWin(minMovie.get().getYear());
			mw.setFollowingWin(maxMovie.get().getYear());
			mw.setInterval(maxMovie.get().getYear() - minMovie.get().getYear());

		}

		return mw;
	}

	@Override
	public List<MovieWinner> listWinnerMin(List<MovieWinner> list) {

		return list
				.stream().min(Comparator.comparing(MovieWinner::getInterval)).map(min -> list.stream()
						.filter(mov -> mov.getInterval().equals(min.getInterval())).collect(Collectors.toList()))
				.orElse(List.of());
	}

	@Override
	public List<MovieWinner> listWinnerMax(List<MovieWinner> list) {

		return list
				.stream().max(Comparator.comparing(MovieWinner::getInterval)).map(max -> list.stream()
						.filter(mov -> mov.getInterval().equals(max.getInterval())).collect(Collectors.toList()))
				.orElse(List.of());

	}

}
