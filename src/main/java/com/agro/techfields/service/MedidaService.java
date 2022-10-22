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

    final Medida novaMedida = new Medida(umidadeDoAr, umidadeDoSolo, temperatura);
    
    Plantacao plantacao = this.plantacaoRepository.getPlantacao(plantacaoId);
    
    List<Ilha> ilhas = plantacao.getIlhas();

    Ilha ilha = this.plantacaoRepository.getIlha(plantacao, ilhaId);
    Integer indexIlha = ilhas.indexOf(ilha);

    ilha.addMedida(novaMedida);
    ilhas.set(indexIlha, ilha);
    plantacaoRepository.update(plantacao);
    return novaMedida;
  }

  /** Lista medidas. */
  public List<Medida> buscarMedidas(String nomePlantacao, ObjectId ilhaId) {
    Plantacao plantacao = this.plantacaoRepository.getPlantacao(nomePlantacao);

    Ilha ilha = this.plantacaoRepository.getIlha(plantacao, ilhaId);
    return ilha.getMedidas();
  }

  /** Atualiza uma medida pelo id passado. */
  public Medida atualizarMedida(ObjectId medidaId, MedidaDto medidaDto) {
    ObjectId plantacaoId = medidaDto.getPlantacaoId();
    ObjectId ilhaId = medidaDto.getIlhaId();

    Plantacao plantacao = this.plantacaoRepository.getPlantacao(plantacaoId);

    List<Ilha> ilhas = plantacao.getIlhas();

    Ilha ilha = this.plantacaoRepository.getIlha(plantacao, ilhaId);
    final Integer indexIlha = ilhas.indexOf(ilha);
    
    List<Medida> medidas = ilha.getMedidas();

    Medida medida = this.plantacaoRepository.getMedida(ilha, medidaId);
    Integer indexMedida = medidas.indexOf(medida); 

    medida = medidas.get(indexMedida);
    medida.setTemperatura(medida.getTemperatura());
    medida.setUmidadeDoAr(medida.getUmidadeDoAr());
    medida.setUmidadeDoSolo(medida.getUmidadeDoSolo());
    medidas.set(indexMedida, medida);

    ilha.setMedidas(medidas);
    ilhas.set(indexIlha, ilha);

    plantacao.setIlhas(ilhas);

    this.plantacaoRepository.update(plantacao);

    return medida;
  }

  /** Deleta uma medida pelo id passado. */
  public MensagemResult deletarMedida(ObjectId medidaId, PlantacaoIlhaDto plantacaoIlhaDto) {
    ObjectId plantacaoId = plantacaoIlhaDto.getPlantacaoId();
    ObjectId ilhaId = plantacaoIlhaDto.getIlhaId();
    Plantacao plantacao = this.plantacaoRepository.getPlantacao(plantacaoId);

    List<Ilha> ilhas = plantacao.getIlhas();

    Ilha ilha = this.plantacaoRepository.getIlha(plantacao, ilhaId);
    final Integer indexIlha = ilhas.indexOf(ilha);

    List<Medida> medidas = ilha.getMedidas();
    Medida medida = this.plantacaoRepository.getMedida(ilha, medidaId);
    medidas.remove(medida);

    ilha.setMedidas(medidas);
    ilhas.set(indexIlha, ilha);
    plantacao.setIlhas(ilhas);

    this.plantacaoRepository.update(plantacao);

    return new MensagemResult("A medida com id " + medidaId + " foi deletada!");
  }
}
