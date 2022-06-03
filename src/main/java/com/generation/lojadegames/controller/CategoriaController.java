package com.generation.lojadegames.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.generation.lojadegames.model.Categoria;
import com.generation.lojadegames.repository.CategoriaRepository;

@RestController
@RequestMapping("/categoria")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CategoriaController {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@GetMapping
	public ResponseEntity<List<Categoria>>getAll(){
		return ResponseEntity.ok(categoriaRepository.findAll());
		
		// select * from tb_categorias;
	}
	
	@GetMapping("/{id")
	public ResponseEntity<Categoria> getById(@PathVariable Long id){
		return categoriaRepository.findById(id)
				.map(resposta -> ResponseEntity.ok(resposta))
				.orElse(ResponseEntity.notFound().build());
		
		// select * from tb_categorias where id = id;
		
	}
	@GetMapping("/genero/{genero}")
	public ResponseEntity<List<Categoria>>getBygenero(@PathVariable String genero){
		return ResponseEntity.ok(categoriaRepository.findAllByGeneroContainingIgnoreCase(genero));
	
		// select * from tb_categorias where genero like "%genero%";
		
	}
	@GetMapping("/classificacaoIndicativa/{classificacaoIndicativa}")
	public ResponseEntity<List<Categoria>>getByclassificacaoIndicativa(@PathVariable String classificacaoIndicativa){
		return ResponseEntity.ok(categoriaRepository.findAllByclassificacaoIndicativaContainingIgnoreCase(classificacaoIndicativa));
	
		// select * from tb_categorias where classificacaoIndicativa like "%classificacaoIndicativa%";	
	}
	
	@PostMapping
	public ResponseEntity<Categoria> postCategoria(@Valid @RequestBody Categoria categoria){
		return ResponseEntity.status(HttpStatus.CREATED).body(categoriaRepository.save(categoria));
		
	}
	@PutMapping
	public ResponseEntity<Categoria> putCategoria(@Valid @RequestBody Categoria categoria){
		return ResponseEntity.status(HttpStatus.OK).body(categoriaRepository.save(categoria));
	}
	
	@DeleteMapping ("/{id")
	public void deleteCategoria(@PathVariable Long id) {
		categoriaRepository.deleteById(id);
	}
	
	
}
