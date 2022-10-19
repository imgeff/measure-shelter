// package com.agro.techfields;
// 
// import static io.restassured.RestAssured.given;
// import static org.junit.jupiter.api.Assertions.assertEquals;
// import static org.junit.jupiter.api.Assertions.assertFalse;
// 
// import com.agro.techfields.dto.PlantacaoDto;
// import com.agro.techfields.model.Plantacao;
// 
// import io.quarkus.test.junit.QuarkusTest;
// import io.restassured.response.Response;
// import javax.ws.rs.core.MediaType;
// import javax.ws.rs.core.Response.Status;
// 
// import org.junit.jupiter.api.Test;
// 
// @QuarkusTest
// public class PlantacaoControllerTest {
// 
//   @Test
//   public void testCriarPlantacaoSucesso() {
//     PlantacaoDto plantacao = new PlantacaoDto("Soja");
//     Response response = given()
//         .contentType(MediaType.APPLICATION_JSON)
//         .body(plantacao)
//         .when()
//         .post("/plantacao");
//     
//     Plantacao responseBody = response.as(Plantacao.class);
// 
//     assertEquals(Status.CREATED.getStatusCode(), response.getStatusCode());
//     assertEquals("Soja", responseBody.getNome());
//     assertFalse(responseBody.getId().isEmpty());
//   }
//   
// }
