package com.cruftlab.words.repository

import com.cruftlab.words.model.Word
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface WordRepository : CrudRepository<Word, Long> {
    /**
     * Find random words
     * @param numberOfWords Fetch this many random words
     * @return Words found in the database
     */
    fun findRandom(numberOfWords: Int): Iterable<Word> {
        return findAll().sortedBy { Math.random() }.subList(0, numberOfWords)
    }
}
