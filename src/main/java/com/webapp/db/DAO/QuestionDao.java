package com.webapp.db.DAO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.webapp.db.model.quiz;

import java.util.List;


@Repository
public interface QuestionDao extends JpaRepository<quiz,Integer> {
    List<quiz> findByCategory(String category);
    @Query(value="select * from quiz q where q.category=:category order by RANDOM() LIMIT :numq",nativeQuery=true)
    List<quiz> findRandomQnsByCategory(String category, int numq);

} 
