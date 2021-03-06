package com.llnunes.cursomc.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.llnunes.cursomc.domain.Produto;
import com.llnunes.cursomc.dto.ProdutoDTO;
import com.llnunes.cursomc.resources.utils.URL;
import com.llnunes.cursomc.services.ProdutoService;

@RestController
@RequestMapping(value="/produtos")
public class ProdutoResource {

	@Autowired
	private ProdutoService produtoService;
	
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {		
		Produto p = produtoService.findById(id);				
		return ResponseEntity.ok(p);
	}
	
	@RequestMapping( method = RequestMethod.GET)
	public ResponseEntity<?> findAll(			
			@RequestParam(value = "nome", defaultValue = "") String nome,
			@RequestParam(value = "categorias", defaultValue = "") String categorias,		
			@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "linesPage", defaultValue = "24") Integer linesPage,
			@RequestParam(value = "orderBy", defaultValue = "nome") String orderBy,
			@RequestParam(value = "direction", defaultValue = "ASC") String direction) {

		List<Integer> ids = URL.decodeIntList(categorias);
		String nomeDecoded = URL.decodeParam(nome);
		
		Page<Produto> list = produtoService.findPage(nomeDecoded, ids, page, linesPage, orderBy, direction);				
		Page<ProdutoDTO> listDto = list.map(obj -> new ProdutoDTO(obj));

		return ResponseEntity.ok().body(listDto);
	}
	
}
