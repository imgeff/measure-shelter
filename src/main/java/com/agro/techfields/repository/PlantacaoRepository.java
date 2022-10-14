package com.agro.techfields.repository;

import com.agro.techfields.model.Plantacao;
import io.quarkus.mongodb.panache.PanacheMongoRepository;

import javax.enterprise.context.ApplicationScoped;



@ApplicationScoped
public class PlantacaoRepository implements PanacheMongoRepository<Plantacao> {
  
}
