package com.sojapplication.model;

import org.springframework.lang.NonNull;

import java.util.List;

public class SojRequest {

    @NonNull
    private List<Integer> numbers;
    @NonNull
    private int quantifier;

    public SojRequest(final List<Integer> numbers, final int quantifier) {
        this.numbers = numbers;
        this.quantifier = quantifier;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public void setNumbers(final List<Integer> numbers) {
        this.numbers = numbers;
    }

    public int getQuantifier() {
        return quantifier;
    }

    public void setQuantifier(final int quantifier) {
        this.quantifier = quantifier;
    }

}
