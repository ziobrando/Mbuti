package it.avanscoperta.mbuti.domain;

import java.time.Duration;

public record VisitorsPerPeriod(
        int visitors, // TODO: probably a different type.
        Duration duration) {
}
