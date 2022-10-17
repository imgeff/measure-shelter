package com.agro.techfields.service;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import com.agro.techfields.dto.PlantacaoDto;
import com.agro.techfields.model.Plantacao;
import com.agro.techfields.repository.PlantacaoRepository;
import com.agro.techfields.result.MensagemResult;

@ApplicationScoped
public class PlantacaoService {
  /**
   * Atributos
   */
  @Inject
  private PlantacaoRepository plantacaoRepository;

  /**
   * Métodos
   * 
   */
  MensagemResult criarPlantacao(PlantacaoDto plantacao) {
    plantacaoRepository.persist(new Plantacao(plantacao.getNome()));
    return new MensagemResult("Plantacao " + plantacao.getNome() + " criada!");
  }
}
