package com.cruftlab.words.model

class CombinedWord(val words: Iterable<CombinedWordPart>) {
    val combinedForm: String = words.joinToString(separator = "", transform = { word -> word.partialForm })
}
