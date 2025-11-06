package com.quizsystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

@Controller
public class QuizController {

    private static final Map<String, String> QUIZ_ANSWERS = new HashMap<>();

    static {
        QUIZ_ANSWERS.put("q1", "New Delhi");
        QUIZ_ANSWERS.put("q2", "Python");
        QUIZ_ANSWERS.put("q3", "<style>");
        QUIZ_ANSWERS.put("q4", "HyperText Markup Language");
        QUIZ_ANSWERS.put("q5", "8 bits");
        QUIZ_ANSWERS.put("q6", "Object-Oriented Programming");
        QUIZ_ANSWERS.put("q7", "Transmission Control Protocol");
        QUIZ_ANSWERS.put("q8", "Central Processing Unit");
        QUIZ_ANSWERS.put("q9", "JavaScript");
        QUIZ_ANSWERS.put("q10", "Uniform Resource Locator");
    }

    @GetMapping("/")
    public String showQuiz() {
        return "index";
    }

    @PostMapping("/quiz")
    public String submitQuiz(@RequestParam Map<String, String> params, Model model) {

        int score = 0;
        int total = QUIZ_ANSWERS.size();

        for (var entry : QUIZ_ANSWERS.entrySet()) {
            String userAnswer = params.get(entry.getKey());
            if (entry.getValue().equals(userAnswer)) {
                score++;
            }
        }

        model.addAttribute("score", score);
        model.addAttribute("total", total);
        return "result";
    }
}
