package com.agro.techfields.service;

import com.agro.techfields.dto.AtualizarIlhaDto;
import com.agro.techfields.dto.IlhaDto;
import com.agro.techfields.error.NotFoundException;
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

    if (plantacao == null) {
      throw new NotFoundException("Plantação");
    }

    plantacao.addIlha(novaIlha);

    plantacaoRepository.update(plantacao);

    return novaIlha;
  }

  /** Busca ilhas. */
  public List<Ilha> buscarIlhas(ObjectId idPlantacao) {

    Plantacao plantacao = plantacaoRepository.findById(idPlantacao);

    if (plantacao == null) {
      throw new NotFoundException("Plantação");
    }

    return plantacao.getIlhas();
  }

  /** Atualiza Ilha. */
  public Ilha atualizarIlha(AtualizarIlhaDto atualizarIlhaDto) {
    ObjectId plantacaoId = atualizarIlhaDto.getPlantacaoId();
    ObjectId ilhaId = atualizarIlhaDto.getIlhaId();
    String area = atualizarIlhaDto.getArea();

    Plantacao plantacao = plantacaoRepository.findById(plantacaoId);

    if (plantacao == null) {
      throw new NotFoundException("Plantação");
    }

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

    if (plantacao == null) {
      throw new NotFoundException("Plantação");
    }

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
