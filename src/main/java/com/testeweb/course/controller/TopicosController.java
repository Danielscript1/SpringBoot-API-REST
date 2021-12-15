package com.testeweb.course.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
	public void cadastrar(@RequestBody TopicoForm form){
		//converter recebendo um form e convetendo para o topico dto
		Topico topico = form.converter(cursoRepository);
		topicoRepository.save(topico);
		
	}
	
}
