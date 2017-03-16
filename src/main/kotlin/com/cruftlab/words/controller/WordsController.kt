package com.cruftlab.words.controller

import com.cruftlab.words.model.Word
import com.cruftlab.words.repository.WordRepository
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController


@RestController
class WordsController(val wordRepository: WordRepository) {
    @GetMapping(value = "/api/words/all")
    fun getAll(): Iterable<Word> {
        return wordRepository.findAll()
    }

    @GetMapping(value = "/api/words/count")
    fun getCount(): Long {
        return wordRepository.count()
    }
}
