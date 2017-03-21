package com.cruftlab.words.repository;

import com.cruftlab.words.exception.WordNotFoundException;
import com.cruftlab.words.model.Word;
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
public class WordRepositoryTest {
    @Autowired
    private WordRepository wordRepository;

    @Test
    public void findAll() throws Exception {
        final Iterable<Word> words = wordRepository.findAll();
        Assert.assertNotNull(words);
        final List<Word> wordList = new ArrayList<>();
        for (Word word : words) {
            wordList.add(word);
            Assert.assertNotNull(word.getId());
        }
        Assert.assertFalse(wordList.isEmpty());
    }

    @Test
    public void findTwoRandom() throws Exception {
        final Iterable<Word> words = wordRepository.findRandom(2);
        Assert.assertNotNull(words);
        final List<Word> wordList = new ArrayList<>();
        for (Word word : words) {
            wordList.add(word);
            Assert.assertNotNull(word.getId());
        }
        Assert.assertFalse(wordList.isEmpty());
        Assert.assertEquals(2, wordList.size());
    }

    @Test
    public void findOneRandomWithValidWord() throws Exception {
        final String expectedFullForm = "sevje";
        final Iterable<Word> words = wordRepository.findRandomWith(1, expectedFullForm);
        Assert.assertNotNull(words);
        final List<Word> wordList = new ArrayList<>();
        for (Word word : words) {
            wordList.add(word);
            Assert.assertNotNull(word.getId());
        }
        Assert.assertFalse(wordList.isEmpty());
        Assert.assertEquals(2, wordList.size());
        final boolean[] hasMatchingWord = {false};
        wordList.forEach(w -> {
            if (w.getFullForm().equals(expectedFullForm)) hasMatchingWord[0] = true;
        });
        Assert.assertTrue("Could not find word matching '" + expectedFullForm + "'", hasMatchingWord[0]);
    }

    @Test(expected = WordNotFoundException.class)
    public void tryToFindFourRandomWithInvalidWord() throws Exception {
        final String expectedFullForm = "fdsajt43t";
        wordRepository.findRandomWith(4, expectedFullForm);
    }

    @Test
    public void assertWordCountIsLargerThanOne() throws Exception {
        final long count = wordRepository.count();
        Assert.assertTrue(count > 1);
    }
}