package br.com.santos.movie.domain.studio;

import org.springframework.stereotype.Service;

import br.com.santos.movie.adapter.studio.repository.model.EntityStudio;
import br.com.santos.movie.domain.studio.model.Studio;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ServiceStudioImpl implements ServiceStudio {

	RepositoryStudio repositoryStudio;

	@Override
	public EntityStudio insert(Studio studio) {
		
		return repositoryStudio.insert(studio);
	}

	@Override
	public Studio findByName(String name) {
		
		return repositoryStudio.findByName(name);
	}
}
