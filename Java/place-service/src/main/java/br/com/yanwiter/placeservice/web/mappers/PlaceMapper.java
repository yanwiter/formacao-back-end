package br.com.yanwiter.placeservice.web.mappers;

import br.com.yanwiter.placeservice.api.PlaceResponse;
import br.com.yanwiter.placeservice.domain.Place;

public class PlaceMapper {
    public static PlaceResponse fromPlaceToResponse (Place place){
        return new PlaceResponse(place.name(), place.slug(), place.state(), place.createdAt(), place.updatedAt());
    }
}
