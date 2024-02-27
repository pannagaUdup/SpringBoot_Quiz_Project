package com.webapp.db.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.webapp.db.DAO.QuestionDao;
import com.webapp.db.DAO.QuizDao;
import com.webapp.db.model.Response;
import com.webapp.db.model.custquiz;
import com.webapp.db.model.questionwrapper;
import com.webapp.db.model.quiz;



@Service
public class QuizService {
    @Autowired
    QuizDao qzdao;
    @Autowired
    QuestionDao qndao;
    public ResponseEntity<String> getcustqn(String category, int numq, String title) {
        // TODO Auto-generated method stub
        List<quiz> questions=qndao.findRandomQnsByCategory(category,numq);
        custquiz cq=new custquiz();
        cq.setTitle(title);
        cq.setQuestions(questions);
        qzdao.save(cq);
        return new ResponseEntity<>("success",HttpStatus.CREATED);
    }
    public ResponseEntity<List<questionwrapper>> getqnsbyid(Integer id) {
        Optional<custquiz> qz=qzdao.findById(id);
        List<quiz> qnsfromdb=qz.get().getQuestions();
        List<questionwrapper> ans=new ArrayList<>();
        for(quiz q:qnsfromdb)
        {
            questionwrapper qw=new questionwrapper(q.getId(), q.getQuestiontitle(), q.getOption1(), q.getOption2(), q.getOption3(), q.getOption4());
            ans.add(qw);
        }
        return new ResponseEntity<>(ans,HttpStatus.OK);
    }

    public ResponseEntity<Integer> getresponsefromservice(Integer id,List<Response> response) {
        Optional<custquiz> qz=qzdao.findById(id);
        List<quiz> qnsfromdb=qz.get().getQuestions();
        int c=0;
        int crtans=0;
        for(Response r:response){
                System.out.println("Answer "+ " "+c+ " "+r.getResponse());
                System.out.println("DbAnswer "+ " "+ " "+qnsfromdb.get(c).getAnswer());
            // #tobecontinued
            if(r.getResponse().equalsIgnoreCase(qnsfromdb.get(c).getAnswer()))
                crtans++;
            c++;
        }
     
        return new ResponseEntity<>(crtans,HttpStatus.OK);
    }

}
