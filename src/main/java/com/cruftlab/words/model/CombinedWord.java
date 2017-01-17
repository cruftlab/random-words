package com.cruftlab.words.model;

public class CombinedWord {
    private final Iterable<CombinedWordPart> words;

    public CombinedWord(Iterable<CombinedWordPart> words) {
        this.words = words;
    }

    public Iterable<CombinedWordPart> getWords() {
        return words;
    }

    public String getCombinedForm() {
        final StringBuilder stringBuilder = new StringBuilder();
        for (CombinedWordPart wordPart : words) {
            stringBuilder.append(wordPart.getPartialForm());
        }
        return stringBuilder.toString().toLowerCase();
    }

}
