// package com.agro.techfields;
// 
// import static io.restassured.RestAssured.given;
// 
// import com.agro.techfields.dto.IlhaDto;
// import com.agro.techfields.dto.MedidaDto;
// import com.agro.techfields.dto.PlantacaoDto;
// import com.agro.techfields.model.Ilha;
// import com.agro.techfields.model.Medida;
// import com.agro.techfields.model.Plantacao;
// import io.restassured.response.Response;
// import javax.ws.rs.core.MediaType;
// 
// import org.bson.types.ObjectId;
// 
// public class UtilTest {
//   
//   /**
//    * Recebe informações da plantação, cria e retorna a plantação registrado no banco.
//    * @param nomePlantacao
//    * nome da plantacao a ser criada.
//    * @return
//    */
//   public static Plantacao criaPlantacao(String nomePlantacao) {
//     PlantacaoDto plantacao = new PlantacaoDto(nomePlantacao);
//     Response response = given()
//         .contentType(MediaType.APPLICATION_JSON)
//         .body(plantacao)
//         .when()
//         .post("/plantacao");
//     
//     Plantacao responseBody = response.as(Plantacao.class);
//     return responseBody;
//   }
// 
//   /**
//    * Recebe informações da ilha, cria e retorna a ilha registrada no banco.
//    * @param plantacaoId
//    * id da plantação
//    * @param area
//    * área da ilha
//    * @return
//    */
//   public static Ilha criaIlha(ObjectId plantacaoId, String area) {
//     IlhaDto ilha = new IlhaDto(plantacaoId, area);
//     Response response = given()
//         .contentType(MediaType.APPLICATION_JSON)
//         .body(ilha)
//         .when()
//         .post("/ilha");
//     
//     Ilha responseBody = response.as(Ilha.class);
//     return responseBody;
//   }
// 
//   /**
//    * Recebe informações de medida, cria e retorna a medida registrada no banco.
//    * @param plantacaoId
//    * id da plantação da ilha que foi feita a medida
//    * @param ilhaId
//    * id da ilha em que foi feita a medida
//    * @param umidadeDoAr
//    * medida da umidade do ar
//    * @param umidadeDoSolo
//    * medida da umidade do solo
//    * @param temperatura
//    * medida da temperatura
//    * @return
//    */
//   public static Medida criaMedida(
//       ObjectId plantacaoId,
//       ObjectId ilhaId,
//       String umidadeDoAr,
//       String umidadeDoSolo,
//       String temperatura
//   ) {
//     MedidaDto medida = new MedidaDto(plantacaoId, ilhaId, umidadeDoAr, umidadeDoSolo, temperatura);
//     Response response = given()
//         .contentType(MediaType.APPLICATION_JSON)
//         .body(medida)
//         .when()
//         .post("/medida");
// 
//     Medida responseBody = response.as(Medida.class);
//     return responseBody;
//   }
// }
