package com.agro.techfields;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;

import com.agro.techfields.dto.PlantacaoDto;

import io.quarkus.test.junit.QuarkusTest;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response.Status;

import org.junit.jupiter.api.Test;

@QuarkusTest
public class PlantacaoControllerTest {

  @Test
  public void testCriarPlantacaoSucesso() {
    PlantacaoDto plantacaoDto = new PlantacaoDto("Soja");
    given()
        .contentType(MediaType.APPLICATION_JSON)
        .body(plantacaoDto)
        .when()
        .post("/plantacao")
        .then()
        .statusCode(Status.CREATED.getStatusCode())
        .body(containsString(plantacaoDto.getNome()));
  }
  
}
