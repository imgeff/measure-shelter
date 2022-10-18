package com.agro.techfields.service;

import com.agro.techfields.dto.PlantacaoDto;
import com.agro.techfields.model.Plantacao;
import com.agro.techfields.repository.PlantacaoRepository;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;


@ApplicationScoped
public class PlantacaoService {

  @Inject
  private PlantacaoRepository plantacaoRepository;

  /**
   * Cria uma nova plantação.
   * @param plantacao
   * informações da plantacao a ser criada
   * @return
   */
  public Plantacao criarPlantacao(PlantacaoDto plantacao) {
    Plantacao novaPlantacao = new Plantacao(plantacao.getNome());
    plantacaoRepository.persist(novaPlantacao);
    return novaPlantacao;
  }
}
