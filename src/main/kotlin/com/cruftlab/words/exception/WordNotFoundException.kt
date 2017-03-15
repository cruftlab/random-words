package com.cruftlab.words.exception

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

/**
 * Exception to be used when trying to find a word,
 * and no such word exists
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "No such word")
class WordNotFoundException(message: String?) : RuntimeException("Word not found: " + message)
