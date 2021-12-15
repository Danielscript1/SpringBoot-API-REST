package com.testeweb.course.controller.form;

import com.testeweb.course.model.Curso;
import com.testeweb.course.model.Topico;
import com.testeweb.course.repository.CursoRepository;

public class TopicoForm {
	private String titulo;
	private String mensagem;
	private String nomeCurso;
	
	
	
	public String getNomeCurso() {
		return nomeCurso;
	}
	public void setNomeCurso(String nomeCurso) {
		this.nomeCurso = nomeCurso;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getMensagem() {
		return mensagem;
	}
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	
	
	public Topico converter(CursoRepository cursoRepository) {
		// TODO Auto-generated method stub
		Curso curso = cursoRepository.findByNome(nomeCurso);
		return new Topico(titulo,mensagem,curso);
	}
	
	
}
