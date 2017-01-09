package com.cruftlab.words.controller;

import com.cruftlab.words.model.Word;
import com.cruftlab.words.service.WordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WordsController {
    private final WordService wordService;

    @Autowired
    public WordsController(WordService wordService) {
        this.wordService = wordService;
    }

    @RequestMapping(value = "/words/all", method = RequestMethod.GET)
    public Iterable<Word> getAll() {
        return wordService.findAll();
    }
}
