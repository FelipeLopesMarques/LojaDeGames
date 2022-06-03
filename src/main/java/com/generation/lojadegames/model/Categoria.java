package com.generation.lojadegames.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table (name = "tb_categorias")
public class Categoria {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
  
	@NotBlank(message = "É obrigatório o preenchimento e não pode conter apenas espaço em branco!")
	@Size(min = 5, max = 50, message = "O atributo deve conter no mínimo 5 e no máximo 50 caracteres!") 
	private String genero;
	
	@NotBlank(message = "É obrigatório o preenchimento e não pode conter apenas espaço em branco!")
	@Size(min = 5, max = 100, message = "O atributo deve conter no mínimo 5 e no máximo 100 caracteres!") 
	private String classificacaoIndicativa;

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
	

}

