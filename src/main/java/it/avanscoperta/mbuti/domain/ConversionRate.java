package it.avanscoperta.mbuti.domain;

public record ConversionRate(double percentage) {
    public ConversionRate {
        if (percentage < 0 || percentage > 1) {
            throw new IllegalArgumentException("A conversion rate should be between 0 and 1");
        }
    }
}
