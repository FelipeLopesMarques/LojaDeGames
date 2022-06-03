package com.generation.lojadegames.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table (name = "tb_categorias")
public class Categoria {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
  
	@NotBlank(message = "É obrigatório o preenchimento e não pode conter apenas espaço em branco!")
	@Size(min = 3, max = 50, message = "O atributo deve conter no mínimo 3 e no máximo 50 caracteres!") 
	private String genero;
	
	@NotBlank(message = "É obrigatório o preenchimento e não pode conter apenas espaço em branco!")
	@Size(min = 5, max = 100, message = "O atributo deve conter no mínimo 5 e no máximo 100 caracteres!") 
	private String classificacaoIndicativa;
	
	@OneToMany (mappedBy = "categoria", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties ("categoria")
	private List<Produto> produto;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getClassificacaoIndicativa() {
		return classificacaoIndicativa;
	}

	public void setClassificacaoIndicativa(String classificacaoIndicativa) {
		this.classificacaoIndicativa = classificacaoIndicativa;
	}

	public List<Produto> getProdutos() {
		return produto;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produto = produtos;
	}

	

}

