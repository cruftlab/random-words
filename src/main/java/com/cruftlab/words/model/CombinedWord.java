package com.cruftlab.words.model;

public class CombinedWord {
    private final Iterable<Word> words;

    public CombinedWord(Iterable<Word> words) {
        this.words = words;
    }

    public Iterable<Word> getWords() {
        return words;
    }

    public String getCombinedForm() {
        final StringBuilder stringBuilder = new StringBuilder();
        for (Word word : words) {
            stringBuilder.append(word.getFullForm());
        }
        return stringBuilder.toString().toLowerCase();
    }

}
