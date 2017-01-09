package com.cruftlab.words.service;

import com.cruftlab.words.model.Word;
import com.cruftlab.words.repository.WordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Service wrapper for {@link WordRepository}
 */
@Service
public class WordService {
    private final WordRepository wordRepository;

    @Autowired
    public WordService(WordRepository wordRepository) {
        this.wordRepository = wordRepository;
    }

    public Iterable<Word> findAll() {
        return wordRepository.findAll();
    }

    public Iterable<Word> findRandom(int numberOfWords) {
        return wordRepository.findRandom(numberOfWords);
    }
}
