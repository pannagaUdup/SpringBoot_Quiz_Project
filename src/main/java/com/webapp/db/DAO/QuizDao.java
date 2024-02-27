package com.webapp.db.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.webapp.db.model.custquiz;

public interface QuizDao extends JpaRepository<custquiz,Integer> {

}
