package kg.megacom.test_app.controllers;

import kg.megacom.test_app.models.dto.QuestionDto;
import kg.megacom.test_app.models.dto.SubjectDto;
import kg.megacom.test_app.models.entities.Question;
import kg.megacom.test_app.models.entities.Subject;
import kg.megacom.test_app.services.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("question")
public class QuestionController {
    @Autowired
    private QuestionService questionService;

    @GetMapping
    public String toSaveQuestion(){
        QuestionDto question = new QuestionDto();
        question.setQuestion("What is a different between class and interface");
        question.set_active(true);
        question.setImage("class vs interface");
        question.setScore(5);
        question.setSubject(new SubjectDto());

        QuestionDto savedQuestion = questionService.save(question);

        return savedQuestion.getQuestion();
    }

}
