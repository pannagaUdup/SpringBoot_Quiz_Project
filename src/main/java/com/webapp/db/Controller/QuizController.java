package com.webapp.db.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.webapp.db.Service.QuizService;
import com.webapp.db.model.Response;
import com.webapp.db.model.questionwrapper;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("makequiz")
public class QuizController {
    @Autowired
    QuizService qs;
    @PostMapping("create")
    public ResponseEntity<String> multiparam(@RequestParam String category,@RequestParam int numq,@RequestParam String title) {
        return qs.getcustqn(category,numq,title);
    }
    @GetMapping("get/{id}")
    public ResponseEntity<List<questionwrapper>> getcustquiz(@PathVariable Integer id) {
        return qs.getqnsbyid(id);
    }
    @PostMapping("submit/{id}")
    public ResponseEntity<Integer> getresponse(@PathVariable Integer id,@RequestBody List<Response> response) {
        return qs.getresponsefromservice(id,response);
    }
    
    
}
