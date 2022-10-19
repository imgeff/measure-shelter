// package com.agro.techfields;
// 
// import static io.restassured.RestAssured.given;
// import static org.junit.jupiter.api.Assertions.assertEquals;
// import static org.junit.jupiter.api.Assertions.assertTrue;
// 
// import com.agro.techfields.dto.IlhaDto;
// import com.agro.techfields.model.Ilha;
// import com.agro.techfields.model.Plantacao;
// import com.agro.techfields.result.MensagemResult;
// 
// import io.quarkus.test.junit.QuarkusTest;
// import io.restassured.response.Response;
// import javax.ws.rs.core.MediaType;
// import javax.ws.rs.core.Response.Status;
// 
// import org.junit.jupiter.api.Test;
// 
// 
// @QuarkusTest
// public class IlhaControllerTest {
// 
//   @Test
//   public void testCriarIlhaSucesso() {
//     Plantacao plantacao = UtilTest.criaPlantacao("Soja");
//     IlhaDto ilha = new IlhaDto(plantacao.getId(), 22);
//     Response response = given()
//         .contentType(MediaType.APPLICATION_JSON)
//         .body(ilha)
//         .when()
//         .post("/ilha");
//     
//     Ilha responseBody = response.as(Ilha.class);
//     
//     assertEquals(Status.CREATED.getStatusCode(), response.getStatusCode());
//     assertEquals("Norte", responseBody.getArea());
//     assertFalse(responseBody.getId().isEmpty());
//   }
// 
//   @Test
//   public void testDeletarIlhaSucesso() {
//     Plantacao plantacao = UtilTest.criaPlantacao("Soja");
//     Ilha ilha = UtilTest.criaIlha(plantacao.getId(), "Norte");
//     Response response = given()
//         .contentType(MediaType.APPLICATION_JSON)
//         .when()
//         .delete(String.format("/ilha/%s/%s", plantacao.getNome(), ilha.getId()));
// 
//     MensagemResult responseBody = response.as(MensagemResult.class);
//     assertEquals(Status.OK.getStatusCode(), response.getStatusCode());
//     assertTrue(responseBody.getMensagem().contains(ilha.getId()));
//   }
//   
// }
