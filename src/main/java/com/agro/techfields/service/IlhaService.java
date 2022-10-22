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
    float area = ilha.getArea();

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
  public List<Ilha> buscarIlhas(ObjectId plantacaoId) {
    Plantacao plantacao = this.plantacaoRepository.getPlantacao(plantacaoId);

    return plantacao.getIlhas();
  }

  /** Atualiza Ilha. */
  public Ilha atualizarIlha(AtualizarIlhaDto atualizarIlhaDto) {
    ObjectId plantacaoId = atualizarIlhaDto.getPlantacaoId();
    ObjectId ilhaId = atualizarIlhaDto.getIlhaId();
    float area = atualizarIlhaDto.getArea();

    Plantacao plantacao = this.plantacaoRepository.getPlantacao(plantacaoId);
    List<Ilha> ilhas = plantacao.getIlhas();

    Ilha ilha = this.plantacaoRepository.getIlha(plantacao, ilhaId);
    ilha.setArea(area);
    Integer indexIlha = ilhas.indexOf(ilha);
    ilhas.set(indexIlha, ilha);
    plantacao.setIlhas(ilhas);

    plantacaoRepository.update(plantacao);
    return ilha;
  }

  /** Deleta ilha. */
  public MensagemResult deletarIlha(String nomePlantacao, ObjectId ilhaId) {
    Plantacao plantacao = this.plantacaoRepository.getPlantacao(nomePlantacao);

    List<Ilha> ilhas = plantacao.getIlhas();

    Ilha ilha = this.plantacaoRepository.getIlha(plantacao, ilhaId);
    ilhas.remove(ilha);

    plantacao.setIlhas(ilhas);
    plantacaoRepository.update(plantacao);

    return new MensagemResult("A ilha de id " + ilhaId + " foi removida com sucesso!");
  }
}
