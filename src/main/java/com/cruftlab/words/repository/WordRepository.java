package com.cruftlab.words.repository;

import com.cruftlab.words.model.Word;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

@Repository
public interface WordRepository extends CrudRepository<Word, Long> {
    /**
     * Find random words
     *
     * @param numberOfWords Fetch this many random words
     * @return Randomized set of words found in the database
     */
    default Iterable<Word> findRandom(final int numberOfWords) {
        final List<Word> allWords = new ArrayList<>();
        for (Word word : findAll()) {
            allWords.add(word);
        }
        final int wordCount = allWords.size();
        if (wordCount < numberOfWords) {
            throw new IllegalStateException("Required " + numberOfWords + " words, but found " + wordCount);
        }
        Collections.shuffle(allWords);
        return allWords.subList(0, numberOfWords);
    }

    /**
     * Find word with matching full form
     *
     * @param fullForm Find word matching this full form
     * @return Matching word
     */
    Word findByFullForm(String fullForm);

    /**
     * Find random words where one of the words are defined already
     *
     * @param numberOfWords Fetch this many random words, excluding the defined word
     * @param fullForm      Find word matching this full form
     * @return Randomized set of words, including the previously defined word
     * @throws NoSuchElementException If no words matching {@code fullForm} is found
     * @see #findRandom(int)
     * @see #findByFullForm(String)
     */
    default Iterable<Word> findRandomWith(final int numberOfWords, final String fullForm) {
        // Find word with matching full form
        final Word matchingWord = findByFullForm(fullForm);
        if (matchingWord == null) {
            throw new NoSuchElementException("No word matching '" + fullForm + "' found");
        }
        // Find all other words
        final List<Word> allOtherWords = new ArrayList<>();
        for (Word word : findAll()) {
            // Only add the other words if they're not the same word as the one matching full form
            if (!word.equals(matchingWord))
                allOtherWords.add(word);
        }
        // Randomize collection
        Collections.shuffle(allOtherWords);
        final List<Word> matches = new ArrayList<>();
        matches.add(matchingWord);
        matches.addAll(allOtherWords.subList(0, numberOfWords));
        Collections.shuffle(matches);
        return matches;
    }
}
