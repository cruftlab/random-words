package com.cruftlab.words.controller

import com.cruftlab.words.model.CombinedWord
import com.cruftlab.words.service.WordCombinatorService
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@RestController
class WordCombinatorController(val wordCombinatorService: WordCombinatorService) {
    @RequestMapping(value = "/api/words/combined/random/{number}", method = arrayOf(RequestMethod.GET))
    fun getTwoRandom(@PathVariable number: Int): CombinedWord {
        return wordCombinatorService.combineRandom(number)
    }
}
