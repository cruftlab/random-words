package com.cruftlab.words.service;

import com.cruftlab.words.model.CombinedWord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WordCombinatorService {
    private final WordService wordService;

    @Autowired
    public WordCombinatorService(WordService wordService) {
        this.wordService = wordService;
    }

    public CombinedWord combineRandom(int number) {
        return new CombinedWord(wordService.findRandom(number));
    }
}
