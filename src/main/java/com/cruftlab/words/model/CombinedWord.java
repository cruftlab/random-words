package com.cruftlab.words.model;

public class CombinedWord {
    private final Iterable<CombinedWordPart> wordParts;

    public CombinedWord(Iterable<CombinedWordPart> words) {
        this.wordParts = words;
    }

    public Iterable<CombinedWordPart> getWordParts() {
        return wordParts;
    }

    public String getCombinedForm() {
        final StringBuilder stringBuilder = new StringBuilder();
        for (CombinedWordPart wordPart : wordParts) {
            stringBuilder.append(wordPart.getPartialForm());
        }
        return stringBuilder.toString().toLowerCase();
    }

}
