package com.agro.techfields.model;

import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;

public class Plantacao {
  public ObjectId id;

  private String nome;

  private List<Ilha> ilhas;

  private List<Imagem> imagens;

  public Plantacao() {
    this.ilhas = new ArrayList<Ilha>();
    this.imagens = new ArrayList<Imagem>();
  }

  /**
   * Cria uma nova plantação.
   * 
   * @param nome nome da plantação
   */
  public Plantacao(String nome) {
    this.nome = nome;
    this.ilhas = new ArrayList<Ilha>();
    this.imagens = new ArrayList<Imagem>();
  }

  public ObjectId getId() {
    return id;
  }

  public String getNome() {
    return nome;
  }

  public List<Ilha> getIlhas() {
    return ilhas;
  }

  public List<Imagem> getImagens() {
    return imagens;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public void setIlhas(List<Ilha> ilhas) {
    this.ilhas = ilhas;
  }

  public void setImagens(List<Imagem> imagens) {
    this.imagens = imagens;
  }

  /** Adiciona Ilha ao array ilhas. */
  public void addIlha(Ilha ilha) {
    this.ilhas.add(ilha);
  }

  /** Adiciona Imagem ao array imagens. */
  public void addImagem(Imagem imagem) {
    this.imagens.add(imagem);
  }
}
