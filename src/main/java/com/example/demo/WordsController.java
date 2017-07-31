package com.example.demo;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/words")
class WordsController {

    private final WordCounter counter;

    WordsController(WordCounter counter) {
        this.counter = counter;
    }

    @PostMapping("/count")
    Map<String, Integer> postWordCount(@RequestBody String body) {
        return counter.count(body);
    }

}
