package com.agro.techfields;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.is;

import com.agro.techfields.model.Ilha;
import com.agro.techfields.model.Medida;
import com.agro.techfields.model.Plantacao;
import com.agro.techfields.repository.PlantacaoRepository;

import io.quarkus.test.junit.QuarkusTest;

import javax.inject.Inject;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response.Status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

@QuarkusTest
public class MedidaControllerTest {

  @Inject
  private PlantacaoRepository plantacaoRepository;

  @BeforeEach
  public void cleanUp() {
    this.plantacaoRepository.deleteAll();
  }
  
  @Test
  public void testBuscarMedidasSucesso() {
    Plantacao plantacao = new Plantacao("Arroz");
    this.plantacaoRepository.persist(plantacao);
    Ilha ilha = new Ilha(1000);
    Medida medida = new Medida("50%", "80%", "18c°");
    ilha.addMedida(medida);
    plantacao.addIlha(ilha);
    this.plantacaoRepository.update(plantacao);
    
    given()
        .contentType(MediaType.APPLICATION_JSON)
        .when()
        .get(String.format("/medida/%s/%s", plantacao.getNome(), ilha.getId()))
        .then()
        .statusCode(Status.OK.getStatusCode())
        .body("size()", is(1))
        .body(containsString(medida.getId().toString()))
        .body("umidadeDoAr", hasItem("50%"))
        .body("umidadeDoSolo", hasItem("80%"))
        .body("temperatura", hasItem("18c°"));

  }
}
