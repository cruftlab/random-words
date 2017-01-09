package com.cruftlab.words.service;

import com.cruftlab.words.model.Word;
import com.cruftlab.words.repository.WordRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * Integration tests for {@link WordRepository}
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class WordServiceIT {
    @Autowired
    private WordService wordService;

    @Test
    public void findAll() throws Exception {
        final Iterable<Word> words = wordService.findAll();
        Assert.assertNotNull(words);
        final List<Word> wordList = new ArrayList<>();
        for (Word word : words) {
            wordList.add(word);
        }
        Assert.assertFalse(wordList.isEmpty());
    }

    @Test
    public void findTwoRandom() throws Exception {
        final Iterable<Word> words = wordService.findRandom(2);
        Assert.assertNotNull(words);
        final List<Word> wordList = new ArrayList<>();
        for (Word word : words) {
            wordList.add(word);
        }
        Assert.assertFalse(wordList.isEmpty());
        Assert.assertEquals(2, wordList.size());
    }
}