package com.cruftlab.words.service;

import com.cruftlab.words.model.CombinedWord;
import com.cruftlab.words.model.CombinedWordPart;
import com.cruftlab.words.model.Word;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class WordCombinatorService {
    private final WordService wordService;

    @Autowired
    public WordCombinatorService(WordService wordService) {
        this.wordService = wordService;
    }

    private static CombinedWordPart getWordPartBasedOnNextWord(final Word firstWord, final Word nextWord) {
        final CombinedWordPart standardCombined = new CombinedWordPart(firstWord, firstWord.getFullForm());
        // Check if the next word starts with the same letter as the previous words two last letters
        final String firstWordFullForm = firstWord.getFullForm();
        if (firstWordFullForm.length() < 2) {
            return standardCombined;
        }
        final String firstWordEndsWith = firstWordFullForm.substring(firstWordFullForm.length() - 2);
        final char nextWordStartsWith = nextWord.getFullForm().charAt(0);
        for (char c : firstWordEndsWith.toCharArray()) {
            if (c != nextWordStartsWith)
                return standardCombined;
        }
        return new CombinedWordPart(firstWord, firstWordFullForm.substring(0, firstWordFullForm.length() - 1));
    }

    private static CombinedWord fromWords(final Iterable<Word> words) {
        // Add all words to list
        final List<Word> wordList = new ArrayList<>();
        for (Word word : words) {
            wordList.add(word);
        }
        // Iterate over each word
        final Collection<CombinedWordPart> wordParts = new ArrayList<>();
        for (int i=0; i<wordList.size(); i++) {
            final Word word = wordList.get(i);
            final CombinedWordPart standardCombined = new CombinedWordPart(word, word.getFullForm());
            // Get next word if possible
            if (wordList.size() > i+1) {
                final Word nextWord = wordList.get(i + 1);
                wordParts.add(getWordPartBasedOnNextWord(word, nextWord));
            } else {
                // Otherwise, just add the word
                wordParts.add(standardCombined);
            }
        }
        return new CombinedWord(wordParts);
    }

    public CombinedWord combineRandom(int number) {
        return fromWords(wordService.findRandom(number));
    }
}
