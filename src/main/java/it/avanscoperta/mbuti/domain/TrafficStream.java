package it.avanscoperta.mbuti.domain;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

public record TrafficStream(VisitorsPerPeriod visitorsPerPeriod) {


    public TrafficStream(int visitorPerDay) {
        this(new VisitorsPerPeriod(visitorPerDay, Duration.of(1, ChronoUnit.DAYS)));
    }

    public int visitorPerDay() {
        return (int) (this.visitorsPerPeriod.visitors() / (
                        visitorsPerPeriod.duration().toMinutes()/Duration.ofDays(1).toMinutes()
                ));
    }
}
