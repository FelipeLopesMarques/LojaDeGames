package com.generation.lojadegames.controller;

import java.math.BigDecimal;
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

import com.generation.lojadegames.model.Produto;
import com.generation.lojadegames.repository.CategoriaRepository;
import com.generation.lojadegames.repository.ProdutoRepository;

@RestController
@RequestMapping("/produtos")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ProdutoController {
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private CategoriaRepository categoriaRepository;

	
	@GetMapping("/produto")
	public ResponseEntity<List<Produto>>getAll(){
		return ResponseEntity.ok(produtoRepository.findAll());
		
		// select * from tb_produtos;
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Produto> getById(@PathVariable Long id){
		return produtoRepository.findById(id)
				.map(resposta -> ResponseEntity.ok(resposta))
				.orElse(ResponseEntity.notFound().build());
		
		// select * from tb_produtos where id = id;
	}
	
	@GetMapping("/nome/{nome}")
	public ResponseEntity<List<Produto>>getBynome(@PathVariable String nome){
		return ResponseEntity.ok(produtoRepository.findAllByNomeContainingIgnoreCase(nome));
		
		// select * from tb_produtos where nome like "%nome%";
	}
	
	@GetMapping("/preco/{preco}")
	public ResponseEntity<List<Produto>>getBypreco(@PathVariable BigDecimal preco){
		return ResponseEntity.ok(produtoRepository.findAllByPrecoLessThanOrderByPreco(preco));
	}
	
	@PostMapping
	public ResponseEntity<Produto> postProduto(@Valid @RequestBody Produto produto){
		return ResponseEntity.status(HttpStatus.CREATED).body(produtoRepository.save(produto));	
	}
	
	@PutMapping
	public ResponseEntity<Produto> putProduto(@Valid @RequestBody Produto produto){
		if(produtoRepository.existsById(produto.getId())){
			if(categoriaRepository.existsById(produto.getCategorias().getId()))
					return ResponseEntity.status(HttpStatus.OK).body(produtoRepository.save(produto));
				
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
	
	@DeleteMapping ("/{id}")
	public ResponseEntity<?> deleteProduto (@PathVariable Long id) {
		return produtoRepository.findById(id)
			.map(response -> {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
			})
					.orElse(ResponseEntity.notFound().build());
	}
	

}
