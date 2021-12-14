package com.testeweb.course.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.testeweb.course.model.Curso;
import com.testeweb.course.model.Topico;

@Controller
public class TopicosController {
	@RequestMapping("/topicos")
	@ResponseBody
	public List<Topico> lista(){
		Topico topico = new Topico("duvida", "spring",new Curso("java","programacao"));
		return Arrays.asList(topico);
	}
}
