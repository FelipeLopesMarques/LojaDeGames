package com.generation.lojadegames.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.generation.lojadegames.model.Categoria;

@Repository
public interface CategoriaRepository extends JpaRepository <Categoria, Long>{

	public List <Categoria> findAllByGeneroContainingIgnoreCase(@Param("genero")String genero);
	public List <Categoria> findAllByclassificacaoIndicativaContainingIgnoreCase(@Param("classificacaoIndicativa")String classificacaoIndicativa);
	
	// select * from tb_categorias where genero like "%genero%";
	// select * from tb_categorias where classificacaoIndicativa like "%classificacaoIndicativa%";
}
