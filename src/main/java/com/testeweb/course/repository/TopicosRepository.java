package com.testeweb.course.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.testeweb.course.model.Topico;

public interface TopicosRepository extends JpaRepository<Topico,Long>{
	
}
