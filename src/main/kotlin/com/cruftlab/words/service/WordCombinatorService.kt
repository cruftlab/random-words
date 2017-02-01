package com.cruftlab.words.service

import com.cruftlab.words.model.CombinedWord
import com.cruftlab.words.model.CombinedWordPart
import com.cruftlab.words.model.Word
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service
class WordCombinatorService
@Autowired
constructor(private val wordService: WordService) {

    private fun getWordPartBasedOnNextWord(firstWord: Word, nextWord: Word): CombinedWordPart {
        val standardCombined = CombinedWordPart(firstWord, firstWord.fullForm)
        // Check if the next word starts with the same letter as the previous words two last letters
        val firstWordFullForm = firstWord.fullForm
        if (firstWordFullForm.length < 2) {
            return standardCombined
        }
        val firstWordEndsWith = firstWordFullForm.substring(firstWordFullForm.length - 2)
        val nextWordStartsWith = nextWord.fullForm[0]
        return if (firstWordEndsWith.toCharArray().any { it != nextWordStartsWith }) standardCombined else CombinedWordPart(firstWord, firstWordFullForm.substring(0, firstWordFullForm.length - 1))
    }

    private fun fromWords(words: Iterable<Word>): CombinedWord {
        // Add all words to list
        val wordList = words.toList()
        // Iterate over each word
        val wordParts = ArrayList<CombinedWordPart>()
        for (i in wordList.indices) {
            val word = wordList[i]
            val standardCombined = CombinedWordPart(word, word.fullForm)
            // Get next word if possible
            if (wordList.size > i + 1) {
                val nextWord = wordList[i + 1]
                wordParts.add(getWordPartBasedOnNextWord(word, nextWord))
            } else {
                // Otherwise, just add the word
                wordParts.add(standardCombined)
            }
        }
        return CombinedWord(wordParts)
    }

    fun combineRandom(number: Int): CombinedWord {
        return fromWords(wordService.findRandom(number))
    }
}
