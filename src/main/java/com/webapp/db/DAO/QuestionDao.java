package com.webapp.db.DAO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.webapp.db.quiz;
import java.util.List;


@Repository
public interface QuestionDao extends JpaRepository<quiz,Integer> {
    List<quiz> findByCategory(String category);
    
} 
