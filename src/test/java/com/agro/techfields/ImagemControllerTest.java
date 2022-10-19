// package com.agro.techfields;
// 
// import static io.restassured.RestAssured.given;
// import static org.junit.jupiter.api.Assertions.assertEquals;
// 
// import io.quarkus.test.junit.QuarkusTest;
// import io.restassured.response.Response;
// import javax.ws.rs.core.MediaType;
// import javax.ws.rs.core.Response.Status;
// 
// import org.junit.jupiter.api.Test;
// 
// @QuarkusTest
// public class ImagemControllerTest {
// 
//   @Test
//   public void testBuscarImagens() {
//     Response response = given()
//         .contentType(MediaType.APPLICATION_JSON)
//         .when()
//         .get("/imagem");
// 
//     assertEquals(Status.OK.getStatusCode(), response.getStatusCode());
//   }
//   
// }
