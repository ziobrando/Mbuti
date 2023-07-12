package it.avanscoperta.mbuti.domain;

public record TrafficLink(
        Node origin,
        ConversionRate conversionRate,
        Node destination) {
}
