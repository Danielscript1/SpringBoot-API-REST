package com.testeweb.course.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.testeweb.course.controller.dto.TopicoDto;
import com.testeweb.course.model.Curso;
import com.testeweb.course.model.Topico;

@RestController
public class TopicosController {
	@RequestMapping("/topicos")
	public List<TopicoDto> lista(){
		Topico topico = new Topico("duvida", "spring",new Curso("java","programacao"));
		//conveter minha lista para dto 
		return TopicoDto.converter(Arrays.asList(topico));
	}
}
