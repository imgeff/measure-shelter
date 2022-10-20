package com.agro.techfields;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.is;

import com.agro.techfields.model.Ilha;
import com.agro.techfields.model.Plantacao;
import com.agro.techfields.repository.PlantacaoRepository;

import io.quarkus.test.junit.QuarkusTest;

import javax.inject.Inject;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response.Status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

@QuarkusTest
public class IlhaControllerTest {

  @Inject
  private PlantacaoRepository plantacaoRepository;

  @BeforeEach
  public void cleanUp() {
    this.plantacaoRepository.deleteAll();
  }

  @Test
  public void testCriarIlhaSucesso() {
    Plantacao plantacao = new Plantacao("Soja");
    this.plantacaoRepository.persist(plantacao);
    Ilha ilha = new Ilha(1000);
    plantacao.addIlha(ilha);
    this.plantacaoRepository.update(plantacao);

    given()
        .contentType(MediaType.APPLICATION_JSON)
        .when()
        .get("/ilha/" + plantacao.getId())
        .then()
        .statusCode(Status.OK.getStatusCode())
        .body("size()",  is(1), "area", hasItem(ilha.getArea()));
    
  }

  @Test
  public void testDeletarIlhaSucesso() {
    Plantacao plantacao = new Plantacao("Café");
    this.plantacaoRepository.persist(plantacao);
    Ilha ilha = new Ilha(2000);
    plantacao.addIlha(ilha);
    this.plantacaoRepository.update(plantacao);

    given()
        .contentType(MediaType.APPLICATION_JSON)
        .when()
        .delete(String.format("/ilha/%s/%s", plantacao.getNome(), ilha.getId()))
        .then()
        .statusCode(Status.OK.getStatusCode())
        .body(containsString("A ilha de id " + ilha.getId() + " foi removida com sucesso!"));

  }
  
}
