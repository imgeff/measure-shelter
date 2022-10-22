package com.agro.techfields.service;

import com.agro.techfields.dto.ImagemDto;
import com.agro.techfields.dto.PlantacaoImagemDto;
import com.agro.techfields.model.Imagem;
import com.agro.techfields.model.Plantacao;
import com.agro.techfields.repository.PlantacaoRepository;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.bson.types.ObjectId;

@ApplicationScoped
public class ImagemService {

  @Inject
  private PlantacaoRepository plantacaoRepository;

  /** Insere uma imagem. */
  public Imagem inserirImagem(ImagemDto image) {
    ObjectId plantacaoId = image.getPlantacaoId();
    String url = image.getUrl();
    Imagem novaImagem = new Imagem(url);

    Plantacao plantacao = this.plantacaoRepository.getPlantacao(plantacaoId);
    
    plantacao.addImagem(novaImagem);

    plantacaoRepository.update(plantacao);

    return novaImagem;
  }

  /** Busca imagens. */
  public List<Imagem> buscarImagens(ObjectId plantacaoId) {
    Plantacao plantacao = this.plantacaoRepository.getPlantacao(plantacaoId);

    return plantacao.getImagens();
  }

  /** Baixa imagem. */
  public Imagem baixarImagem(PlantacaoImagemDto plantacaoImagemDto) {
    ObjectId plantacaoId = plantacaoImagemDto.getPlantacaoId();
    ObjectId imagemId = plantacaoImagemDto.getImagemId();

    Plantacao plantacao = this.plantacaoRepository.getPlantacao(plantacaoId);

    Imagem imagem = this.plantacaoRepository.getImagem(plantacao, imagemId);
    return imagem;
  }

}
