package br.com.santos.movie.adapter.studio.repository;

import org.springframework.stereotype.Component;

import br.com.santos.movie.adapter.studio.repository.model.EntityStudio;
import br.com.santos.movie.domain.studio.RepositoryStudio;
import br.com.santos.movie.domain.studio.model.Studio;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class RepositorySpringStudioImpl implements RepositoryStudio {

	RepositorySprinStudio repositorySpringStudio;

	@Override
	public EntityStudio insert(Studio studio) {
		return repositorySpringStudio.save(
				EntityStudio.convertToEntityStudio(studio));
	}

	@Override
	public Studio findByName(String name) {

		var entity = repositorySpringStudio.findByName(name)
				.orElseGet(() -> new EntityStudio());
		return entity.convertToStudio();
	}
}
