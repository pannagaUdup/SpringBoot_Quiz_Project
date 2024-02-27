package com.webapp.db.Service;

import java.util.List;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.webapp.db.DAO.QuestionDao;
import com.webapp.db.model.quiz;

@Service
public class QuestionService {
    @Autowired
    QuestionDao qd;
    public List<quiz> getQnsByCtg;
    public ResponseEntity<List<quiz>> getQuestions() {
        try{
       return new ResponseEntity<>(qd.findAll(),HttpStatus.OK);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);
    }
    public ResponseEntity<List<quiz>> getQuestionByCategory(String Category) {
        try{
        return new ResponseEntity<>(qd.findByCategory(Category),HttpStatus.OK);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);
    }
    public ResponseEntity<String> addQuestionToDB(quiz getQn) {
        qd.save(getQn);
        return new ResponseEntity<>("Succcesss",HttpStatus.CREATED);
    }
    
}
