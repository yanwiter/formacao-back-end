package br.com.yanwiter.placeservice;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.web.reactive.server.WebTestClient;

import br.com.yanwiter.placeservice.api.PlaceRequest;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class PlaceServiceApplicationTests {

	@Autowired
	WebTestClient webTestClient;

	@Test
	void testCreatePlaceSucess(){

		var name = "Valid name";
		var state = "Valid state";
		var slug = "valid-name";

		webTestClient
		.post()
		.uri("/places")
		.bodyValue(
			new PlaceRequest(name, state)
		)
		.exchange()
		.expectBody()
		.jsonPath("name").isEqualTo(name)
		.jsonPath("state").isEqualTo(state)
		.jsonPath("slug").isEqualTo(slug)
		.jsonPath("createdAt").isNotEmpty()
		.jsonPath("updatedAt").isNotEmpty();
	}

	@Test
	void testCreatePlaceFailure(){
		var name = "";
		var state = "";
		var slug = "";

		webTestClient
		.post()
		.uri("/places")
		.bodyValue(
			new PlaceRequest(name, state)
		)
		.exchange()
		.expectStatus()
		.isBadRequest();
	}

}
