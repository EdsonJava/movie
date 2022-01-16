package br.com.santos.movie.domain.studio;

import br.com.santos.movie.adapter.studio.repository.model.EntityStudio;
import br.com.santos.movie.domain.studio.model.Studio;

public interface ServiceStudio {
	
	EntityStudio insert(Studio studio);
	Studio findByName(String name);

}
