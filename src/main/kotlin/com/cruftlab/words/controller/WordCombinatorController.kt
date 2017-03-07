package com.cruftlab.words.controller

import com.cruftlab.words.model.CombinedWord
import com.cruftlab.words.service.WordCombinatorService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class WordCombinatorController(val wordCombinatorService: WordCombinatorService) {
    @GetMapping(value = "/api/words/combined/random/{number}")
    fun getRandom(@PathVariable number: Int): CombinedWord {
        return wordCombinatorService.combineRandom(number)
    }

    @GetMapping(value = "/api/words/combined/randomWith/{number}/{word}")
    fun getRandomWith(@PathVariable number: Int, @PathVariable word: String): CombinedWord {
        return wordCombinatorService.combineRandomWith(number, word)
    }
}
