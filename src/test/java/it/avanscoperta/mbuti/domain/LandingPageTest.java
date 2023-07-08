package it.avanscoperta.mbuti.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.time.temporal.ChronoUnit;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LandingPageTest {


    private URL url;
    private LandingPage landingPage;

    @BeforeEach
    void setUp() throws MalformedURLException {
        url = new URL("https://eventstorming.com");
    }

    @Test
    void can_create_a_landing_page() {
        String label = "Test Landing Page";
        landingPage = new LandingPage(
                label, url
        );

        assertNotNull(landingPage);
    }

    @Test
    void can_add_an_incoming_traffic_stream() {
        TrafficStream trafficStream = new TrafficStream(new VisitorsPerPeriod(200, Duration.of(1, ChronoUnit.DAYS)));
        String label = "Test Landing Page";
        landingPage = new LandingPage(
                label, url
        );

        landingPage.addIncomingTrafficStream("Organic", trafficStream);

        assertTrue(landingPage.incomingTrafficStreams().contains(trafficStream));


    }
}
