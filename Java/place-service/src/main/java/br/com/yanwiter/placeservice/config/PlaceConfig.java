package br.com.yanwiter.placeservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.r2dbc.config.EnableR2dbcAuditing;

import br.com.yanwiter.placeservice.domain.repository.PlaceRepository;
import br.com.yanwiter.placeservice.domain.service.PlaceService;

@Configuration
@EnableR2dbcAuditing
public class PlaceConfig {
	
	@Bean
	PlaceService placeService(PlaceRepository placeRepository){
		return new PlaceService(placeRepository);
	}

}
