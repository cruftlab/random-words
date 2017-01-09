package com.cruftlab.words.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Word {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String fullForm;

    public Word() {
    }

    public Word(String fullForm) {
        this.fullForm = fullForm;
    }

    public Integer getId() {
        return id;
    }

    public String getFullForm() {
        return fullForm;
    }

    @Override
    public String toString() {
        return fullForm;
    }
}
