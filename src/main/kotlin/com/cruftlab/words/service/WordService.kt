package com.cruftlab.words.service

import com.cruftlab.words.model.Word
import com.cruftlab.words.repository.WordRepository
import org.springframework.stereotype.Service

/**
 * Service wrapper for {@link WordRepository}
 */
@Service
class WordService(val wordRepository: WordRepository) {
    fun findAll() : Iterable<Word> {
        return wordRepository.findAll()
    }

    fun findRandom(numberOfWords: Int) : Iterable<Word> {
        return wordRepository.findRandom(numberOfWords)
    }
}
