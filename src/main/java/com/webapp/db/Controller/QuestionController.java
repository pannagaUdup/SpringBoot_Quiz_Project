package com.webapp.db.Controller;

import org.springframework.web.bind.annotation.RestController;

import com.webapp.db.Service.QuestionService;
import com.webapp.db.model.quiz;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("question")

public class QuestionController {
    @Autowired
    QuestionService qs;
    @GetMapping("allqns")
    public ResponseEntity<List<quiz>> getAllQnsString() {
        return qs.getQuestions();
    }
    @GetMapping()
    public ResponseEntity<List<quiz>> QuestionByCategory(@RequestParam String category) {
        return qs.getQuestionByCategory(category);
    }
    @PostMapping("add")
    public ResponseEntity<String> addQuestion(@RequestBody quiz addQn) {
        //TODO: process POST request
        return qs.addQuestionToDB(addQn);
    }
}
