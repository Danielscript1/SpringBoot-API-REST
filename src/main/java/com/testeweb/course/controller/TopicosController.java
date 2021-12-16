package com.testeweb.course.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.testeweb.course.controller.dto.DetalhesDoTopicoDto;
import com.testeweb.course.controller.dto.TopicoDto;
import com.testeweb.course.controller.form.TopicoForm;
import com.testeweb.course.model.Topico;
import com.testeweb.course.repository.CursoRepository;
import com.testeweb.course.repository.TopicosRepository;

@RestController
@RequestMapping(value="/topicos")
public class TopicosController {
	
	
	@Autowired
	private TopicosRepository topicoRepository;
	@Autowired
	private CursoRepository cursoRepository;
	
	@GetMapping
	public List<TopicoDto> lista(String nomeCurso) {
		if (nomeCurso == null) {
			List<Topico> topicos = topicoRepository.findAll();
			return TopicoDto.converter(topicos);
		} else {
			List<Topico> topicos = topicoRepository.findByCursoNome(nomeCurso);
			return TopicoDto.converter(topicos);
		}
	}
	@PostMapping
	public ResponseEntity<TopicoDto> cadastrar(@RequestBody @Validated TopicoForm form , UriComponentsBuilder uriBuilder){
		//converter recebendo um form e convetendo para o topico dto
		Topico topico = form.converter(cursoRepository);
		topicoRepository.save(topico);
		URI uri = uriBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();
		return ResponseEntity.created(uri).body(new TopicoDto(topico));
	}
	//buscandoResultadosPeloId
	@GetMapping("/{id}")
	public DetalhesDoTopicoDto detalhar(@PathVariable Long id) {
		Topico topico = topicoRepository.getById(id);
		return new DetalhesDoTopicoDto(topico);
	}
	
}
