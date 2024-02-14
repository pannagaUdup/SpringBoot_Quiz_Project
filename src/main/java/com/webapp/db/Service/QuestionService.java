package com.webapp.db.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webapp.db.quiz;
import com.webapp.db.DAO.QuestionDao;

@Service
public class QuestionService {
    @Autowired
    QuestionDao qd;
    public List<quiz> getQnsByCtg;
    public List<quiz> getQuestions() {
       return qd.findAll();
    }
    public List<quiz> getQuestionByCategory(String Category) {
        return qd.findByCategory(Category);
    }
    public String addQuestionToDB(quiz getQn) {
        qd.save(getQn);
        return "Success";
    }
    
}
