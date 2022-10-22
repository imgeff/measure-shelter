package com.agro.techfields.repository;

import com.agro.techfields.error.NotFoundException;
import com.agro.techfields.model.Ilha;
import com.agro.techfields.model.Imagem;
import com.agro.techfields.model.Medida;
import com.agro.techfields.model.Plantacao;
import io.quarkus.mongodb.panache.PanacheMongoRepository;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import org.bson.types.ObjectId;




@ApplicationScoped
public class PlantacaoRepository implements PanacheMongoRepository<Plantacao> {

  public Plantacao getPlantacao(ObjectId plantacaoId) {
    Plantacao plantacao = this.findById(plantacaoId);

    if (plantacao == null) {
      throw new NotFoundException("Plantação");
    }

    return plantacao;
  }

  public Plantacao getPlantacao(String nomePlantacao) {
    Plantacao plantacao = this.find("nome", nomePlantacao).firstResult();

    if (plantacao == null) {
      throw new NotFoundException("Plantação");
    }
    
    return plantacao;
  }

  /**
   * Busca uma Ilha.
   * @param plantacao
   * plantação a qual a ilha a ser buscada pertence
   * @param ilhaId
   * id da ilha a ser buscada
   * @return
   */
  public Ilha getIlha(Plantacao plantacao, ObjectId ilhaId) {
    List<Ilha> ilhas = plantacao.getIlhas();
    Ilha ilha = null;
    for (int index = 0; index < ilhas.size(); index += 1) {
      Ilha ilhaDoLoop = ilhas.get(index);
      if (ilhaDoLoop.getId().equals(ilhaId)) {
        ilha = ilhas.get(index);
      } else if (index == ilhas.size() - 1 & ilha.equals(null)) {
        throw new NotFoundException("Ilha");
      }
    }
    return ilha;
  }

  /**
   * Busca uma medida.
   * @param ilha
   * ilha a qual a medida a ser buscada pertence
   * @param medidaId
   * id da medida a ser buscada
   * @return
   */
  public Medida getMedida(Ilha ilha, ObjectId medidaId) {
    List<Medida> medidas = ilha.getMedidas();
    Medida medida = null;
    for (int index = 0; index < medidas.size(); index += 1) {
      Medida medidaDoLoop = medidas.get(index);
      if (medidaDoLoop.getId().equals(medidaId)) {
        medida = medidas.get(index);
      } else if (index == medidas.size() - 1 & medida.equals(null)) {
        throw new NotFoundException("Medida");
      }
    }
    return medida;
  }

  /**
   * Busca uma imagem.
   * @param plantacao
   * plantação a qual a imagem a ser buscada pertence
   * @param imagemId
   * id da imagem a ser buscada
   * @return
   */
  public Imagem getImagem(Plantacao plantacao, ObjectId imagemId) {
    List<Imagem> imagens = plantacao.getImagens();
    Imagem imagem = null;
    for (int index = 0; index < imagens.size(); index += 1) {
      Imagem imagemDoLoop = imagens.get(index);
      if (imagemDoLoop.getId().equals(imagemId)) {
        imagem = imagens.get(index);
      } else if (index == imagens.size() - 1 & imagem.equals(null)) {
        throw new NotFoundException("Imagem");
      }
    }
    return imagem;
  }
  
}
