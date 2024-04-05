package br.com.yanwiter.placeservice.domain.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import br.com.yanwiter.placeservice.domain.Place;

public interface PlaceRepository extends ReactiveCrudRepository <Place, Long> {

}
