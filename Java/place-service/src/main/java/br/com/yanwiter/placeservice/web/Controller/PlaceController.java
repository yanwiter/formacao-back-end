package br.com.yanwiter.placeservice.web.Controller;

import org.springframework.web.bind.annotation.RestController;

import br.com.yanwiter.placeservice.api.PlaceRequest;
import br.com.yanwiter.placeservice.api.PlaceResponse;
import br.com.yanwiter.placeservice.domain.service.PlaceService;
import br.com.yanwiter.placeservice.web.mappers.PlaceMapper;
import jakarta.validation.Valid;
import reactor.core.publisher.Mono;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/places")
public class PlaceController {

	private PlaceService placeService;
	
	public PlaceController(PlaceService placeService) {
		this.placeService = placeService;
	}

	@PostMapping
	public ResponseEntity<Mono<PlaceResponse>> create(@Valid @RequestBody PlaceRequest request) {
		var PlaceResponse = placeService.create(request).map(PlaceMapper::fromPlaceToResponse);
		return ResponseEntity.status(HttpStatus.CREATED).body(PlaceResponse);
	}

	
	
}
