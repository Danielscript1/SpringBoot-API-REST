package com.testeweb.course.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.testeweb.course.controller.dto.TopicoDto;
import com.testeweb.course.model.Curso;
import com.testeweb.course.model.Topico;
import com.testeweb.course.repository.TopicosRepository;

@RestController
public class TopicosController {
	
	
	@Autowired
	private TopicosRepository topicoRepository;
	
	@RequestMapping("/topicos")
	public List<TopicoDto> lista(String nomeCurso) {
		if (nomeCurso == null) {
			List<Topico> topicos = topicoRepository.findAll();
			return TopicoDto.converter(topicos);
		} else {
			List<Topico> topicos = topicoRepository.findByCursoNome(nomeCurso);
			return TopicoDto.converter(topicos);
		}
	}
}
