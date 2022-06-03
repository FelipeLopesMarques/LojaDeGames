package com.generation.lojadegames.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table (name = "tb_produtos")
public class Produto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "Este Campo é obrigatório e não pode conter apenas espaço em branco!")
	@Size(min = 5, max = 50, message = "O atributo deve conter no mínimo 5 e no máximo 50 caracteres!") 
	private String nome;
	
	private String foto;
	
	@NotBlank(message = "Este Campo é obrigatório e não pode conter apenas espaço em branco!")
	@Size(min = 5, max = 550, message = "O atributo deve conter no mínimo 5 e no máximo 550 caracteres!") 
	private String descricao;
	
	@NotBlank(message = "Este Campo é obrigatório e não pode conter apenas espaço em branco!")
	@Size(min = 5, max = 500, message = "O atributo deve conter no mínimo 5 e no máximo 500 caracteres!") 
	private String sinopse;
	
	@NotBlank(message = "Este Campo é obrigatório e não pode conter apenas espaço em branco!")
	@Size(min = 5, max = 30, message = "O atributo deve conter no mínimo 5 e no máximo 30 caracteres!") 
	private String console;
	
	@NotNull(message = "Este Campo é obrigatório!")
	@Positive(message = "Este é obrigatório e deve conter valor positivo!")
	private int ano_lancamento;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING)
	@NotNull(message = "Este Campo é obrigatório!")
	@Positive(message = "Este é obrigatório e deve conter valor maior que zero!") 
	private BigDecimal preco;
	
	@ManyToOne
	@JsonIgnoreProperties ("produto")
	private Categoria categoria;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getSinopse() {
		return sinopse;
	}

	public void setSinopse(String sinopse) {
		this.sinopse = sinopse;
	}

	public String getConsole() {
		return console;
	}

	public void setConsole(String console) {
		this.console = console;
	}

	public int getAno_lancamento() {
		return ano_lancamento;
	}

	public void setAno_lancamento(int ano_lancamento) {
		this.ano_lancamento = ano_lancamento;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public Categoria getCategorias() {
		return categoria;
	}

	public void setCategorias(Categoria categorias) {
		this.categoria = categorias;
	}


}
