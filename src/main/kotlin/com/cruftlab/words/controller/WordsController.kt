package com.cruftlab.words.controller

import com.cruftlab.words.model.Word
import com.cruftlab.words.service.WordService
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController


@RestController
class WordsController(val wordService: WordService) {
    @RequestMapping(value = "/api/words/all", method = arrayOf(RequestMethod.GET))
    fun getAll(): Iterable<Word> {
        return wordService.findAll()
    }
}
