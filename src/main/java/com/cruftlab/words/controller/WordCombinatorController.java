package com.cruftlab.words.controller;

import com.cruftlab.words.model.CombinedWord;
import com.cruftlab.words.service.WordCombinatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WordCombinatorController {
    private final WordCombinatorService wordCombinatorService;

    @Autowired
    public WordCombinatorController(WordCombinatorService wordCombinatorService) {
        this.wordCombinatorService = wordCombinatorService;
    }

    @RequestMapping(value = "/random/{number}", method = RequestMethod.GET)
    public CombinedWord getTwoRandom(@PathVariable int number) {
        return wordCombinatorService.combineRandom(number);
    }
}
