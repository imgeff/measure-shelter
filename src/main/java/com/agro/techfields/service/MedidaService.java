package com.agro.techfields.service;

import com.agro.techfields.dto.MedidaDto;
import com.agro.techfields.dto.PlantacaoIlhaDto;
import com.agro.techfields.model.Ilha;
import com.agro.techfields.model.Medida;
import com.agro.techfields.model.Plantacao;
import com.agro.techfields.repository.PlantacaoRepository;
import com.agro.techfields.result.MensagemResult;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.bson.types.ObjectId;

@ApplicationScoped
public class MedidaService {

  @Inject
  private PlantacaoRepository plantacaoRepository;

  /** Cria uma medida. */
  public Medida criarMedida(MedidaDto medida) {

    String umidadeDoAr = medida.getUmidadeDoAr();
    String umidadeDoSolo = medida.getUmidadeDoSolo();
    String temperatura = medida.getTemperatura();
    ObjectId ilhaId = medida.getIlhaId();
    ObjectId plantacaoId = medida.getPlantacaoId();

    Medida novaMedida = new Medida(umidadeDoAr, umidadeDoSolo, temperatura);

    Plantacao plantacao = plantacaoRepository.findById(plantacaoId);
    List<Ilha> ilhas = plantacao.getIlhas();

    int indexIlha = -1;
    Ilha ilha = null;

    for (int index = 0; index < ilhas.size(); index += 1) {
      if (ilhas.get(index).getId().equals(ilhaId)) {
        indexIlha = index;
        ilha = ilhas.get(index);
      }
    }

    ilha.addMedida(novaMedida);
    ilhas.set(indexIlha, ilha);
    plantacaoRepository.update(plantacao);
    return novaMedida;
  }

  /** Lista medidas. */
  public List<Medida> buscarMedidas(String nomePlantacao, ObjectId ilhaId) {
    Plantacao plantacao = plantacaoRepository.find("nome", nomePlantacao).firstResult();

    List<Ilha> ilhas = plantacao.getIlhas();

    Ilha ilhaDaMedida = ilhas.stream().filter(ilha -> ilha.getId().equals(ilhaId)).findFirst()
        .orElse(null);

    return ilhaDaMedida.getMedidas();
  }

  /** Atualiza uma medida pelo id passado. */
  public Medida atualizarMedida(ObjectId medidaId, MedidaDto medida) {
    ObjectId plantacaoId = medida.getPlantacaoId();
    ObjectId ilhaId = medida.getIlhaId();

    Plantacao plantacao = plantacaoRepository.findById(plantacaoId);
    List<Ilha> ilhas = plantacao.getIlhas();

    int indexIlha = -1;
    Ilha ilha = null;

    for (int index = 0; index < ilhas.size(); index += 1) {
      if (ilhas.get(index).getId().equals(ilhaId)) {
        indexIlha = index;
        ilha = ilhas.get(index);
      }
    }

    List<Medida> medidas = ilha.getMedidas();

    Medida medidaAtualizada = null;

    for (int index = 0; index < medidas.size(); index += 1) {
      if (medidas.get(index).getId().equals(medidaId)) {
        medidaAtualizada = medidas.get(index);
        medidaAtualizada.setTemperatura(medida.getTemperatura());
        medidaAtualizada.setUmidadeDoAr(medida.getUmidadeDoAr());
        medidaAtualizada.setUmidadeDoSolo(medida.getUmidadeDoSolo());
        medidas.set(index, medidaAtualizada);
      }
    }

    ilha.setMedidas(medidas);
    ilhas.set(indexIlha, ilha);

    plantacao.setIlhas(ilhas);

    this.plantacaoRepository.update(plantacao);

    return medidaAtualizada;
  }

  /** Deleta uma medida pelo id passado. */
  public MensagemResult deletarMedida(ObjectId medidaId, PlantacaoIlhaDto plantacaoIlhaDto) {
    ObjectId plantacaoId = plantacaoIlhaDto.getPlantacaoId();
    ObjectId ilhaId = plantacaoIlhaDto.getIlhaId();
    Plantacao plantacao = plantacaoRepository.findById(plantacaoId);

    List<Ilha> ilhas = plantacao.getIlhas();

    int indexIlha = -1;
    Ilha ilha = null;

    for (int index = 0; index < ilhas.size(); index += 1) {
      if (ilhas.get(index).getId().equals(ilhaId)) {
        indexIlha = index;
        ilha = ilhas.get(index);
      }
    }

    List<Medida> medidas = ilha.getMedidas();
    for (int index = 0; index < medidas.size(); index += 1) {
      if (medidas.get(index).getId().equals(medidaId)) {
        medidas.remove(index);
      }
    }

    ilha.setMedidas(medidas);
    ilhas.set(indexIlha, ilha);
    plantacao.setIlhas(ilhas);

    this.plantacaoRepository.update(plantacao);

    return new MensagemResult("A medida com id " + medidaId + " foi deletada!");
  }
}
