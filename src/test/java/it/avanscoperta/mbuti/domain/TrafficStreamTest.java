package it.avanscoperta.mbuti.domain;

import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

import static org.junit.jupiter.api.Assertions.*;

public class TrafficStreamTest
{
    @Test
    void can_create_a_TrafficStream() {
        TrafficStream trafficStream = new TrafficStream(new VisitorsPerPeriod(100, Duration.of(1, ChronoUnit.DAYS)));
        assertNotNull(trafficStream);
    }

    @Test
    void can_create_a_TrafficStream_with_shortcut() {
        TrafficStream trafficStream = new TrafficStream(100);
        assertNotNull(trafficStream);
    }

    @Test
    void can_derive_visitors_per_day() {
        TrafficStream trafficStream = new TrafficStream(
                new VisitorsPerPeriod(700, Duration.of(7, ChronoUnit.DAYS))
        );
        assertEquals(100, trafficStream.visitorPerDay());
    }


}
