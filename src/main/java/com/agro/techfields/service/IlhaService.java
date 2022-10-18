package com.agro.techfields.service;

import com.agro.techfields.dto.IlhaDto;
import com.agro.techfields.dto.PlantacaoIlhaDto;
import com.agro.techfields.model.Ilha;
import com.agro.techfields.model.Plantacao;
import com.agro.techfields.repository.PlantacaoRepository;
import com.agro.techfields.result.MensagemResult;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.bson.types.ObjectId;

@ApplicationScoped
public class IlhaService {

  @Inject
  private PlantacaoRepository plantacaoRepository;

  /** Cria ilha. */
  public Ilha criarIlha(IlhaDto ilha) {
    ObjectId plantacaoId = ilha.getPlantacaoId();
    String area = ilha.getArea();

    Ilha novaIlha = new Ilha(area);

    Plantacao plantacao = plantacaoRepository.findById(plantacaoId);
    plantacao.addIlha(novaIlha);

    plantacaoRepository.update(plantacao);

    return novaIlha;
  }

  /** Busca ilhas. */
  public List<Ilha> buscarIlhas(ObjectId idPlantacao) {

    Plantacao plantacao = plantacaoRepository.findById(idPlantacao);

    return plantacao.getIlhas();
  }

  /** Atualiza Ilha. */
  public Ilha atualizarIlha(PlantacaoIlhaDto plantacaoIlhaDto, IlhaDto ilha) {
    ObjectId plantacaoId = ilha.getPlantacaoId();
    ObjectId ilhaId = plantacaoIlhaDto.getIlhaId();
    String area = ilha.getArea();

    Plantacao plantacao = plantacaoRepository.findById(plantacaoId);

    List<Ilha> ilhas = plantacao.getIlhas();

    Ilha ilhaSelecionada = null;

    for (int index = 0; index < ilhas.size(); index += 1) {
      if (ilhas.get(index).getId().equals(ilhaId)) {
        ilhaSelecionada = ilhas.get(index);
        ilhaSelecionada.setArea(area);
        ilhas.set(index, ilhaSelecionada);
      }
    }

    plantacao.setIlhas(ilhas);

    plantacaoRepository.update(plantacao);
    return ilhaSelecionada;
  }

  /** Deleta ilha. */
  public MensagemResult deletarIlha(String nomePlantacao, ObjectId ilhaId) {
    Plantacao plantacao = plantacaoRepository.find("nome", nomePlantacao).firstResult();

    List<Ilha> ilhas = plantacao.getIlhas();

    for (int index = 0; index < ilhas.size(); index += 1) {
      if (ilhas.get(index).getId().equals(ilhaId)) {
        ilhas.remove(index);
      }
    }

    plantacao.setIlhas(ilhas);
    plantacaoRepository.update(plantacao);

    return new MensagemResult("A ilha de id " + ilhaId + " foi removida com sucesso!");
  }
}
