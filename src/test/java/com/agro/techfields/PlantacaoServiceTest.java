// package com.agro.techfields;
// 
// import static org.junit.jupiter.api.Assertions.assertNotNull;
// 
// import javax.inject.Inject;
// 
// import com.agro.techfields.dto.PlantacaoDto;
// import com.agro.techfields.model.Plantacao;
// import com.agro.techfields.service.PlantacaoService;
// 
// import org.junit.jupiter.api.Test;
// 
// import io.quarkus.test.junit.QuarkusTest;
// 
// @QuarkusTest
// public class PlantacaoServiceTest {
// 
//   @Inject
//   private PlantacaoService plantacaoService;
//   
//   @Test
//   public void criaPlantacaoTest() {
//     Plantacao novaPlantacao = this.plantacaoService.criarPlantacao(new PlantacaoDto("Feijão"));
//     System.out.println("======================== AQUI =======================");
//     System.out.println(novaPlantacao.getNome());
//     assertNotNull(novaPlantacao);
//   }
// }
