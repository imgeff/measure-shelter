// package com.agro.techfields;

// import static io.restassured.RestAssured.given;
// import static org.junit.jupiter.api.Assertions.assertEquals;
// import static org.junit.jupiter.api.Assertions.assertTrue;

// import com.agro.techfields.dto.MedidaDto;
// import com.agro.techfields.model.Ilha;
// import com.agro.techfields.model.Medida;
// import com.agro.techfields.model.Plantacao;
// import com.agro.techfields.result.MensagemResult;

// import io.quarkus.test.junit.QuarkusTest;
// import io.restassured.response.Response;
// import javax.ws.rs.core.MediaType;
// import javax.ws.rs.core.Response.Status;

// import org.junit.jupiter.api.Test;

// @QuarkusTest
// public class MedidaControllerTest {
  
//   @Test
//   public void testAtualizarMedidaSucesso() {
//     Plantacao plantacao = UtilTest.criaPlantacao("Soja");
//     Ilha ilha = UtilTest.criaIlha(plantacao.getId(), "Norte");
//     Medida medida = UtilTest.criaMedida(plantacao.getId(), ilha.getId(), "60%", "50%", "15C°");
//     MedidaDto medidaAtualizada = 
//         new MedidaDto(plantacao.getId(), ilha.getId(), "50%", "50%", "16C°");
    
//     Response response = given()
//         .contentType(MediaType.APPLICATION_JSON)
//         .body(medidaAtualizada)
//         .when()
//         .put(String.format("/medida/%s", medida.getId()));

//     MensagemResult responseBody = response.as(MensagemResult.class);

//     assertEquals(Status.OK.getStatusCode(), response.getStatusCode());
//     assertTrue(responseBody.getMensagem().contains(medida.getId()));
//   }
// }
