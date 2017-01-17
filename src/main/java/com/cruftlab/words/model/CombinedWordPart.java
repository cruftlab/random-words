package com.cruftlab.words.model;

public class CombinedWordPart {
    private final Word word;
    private final String partialForm;

    public CombinedWordPart(Word word, String partialForm) {
        this.word = word;
        this.partialForm = partialForm;
    }

    public Word getWord() {
        return word;
    }

    public String getPartialForm() {
        return partialForm;
    }
}
