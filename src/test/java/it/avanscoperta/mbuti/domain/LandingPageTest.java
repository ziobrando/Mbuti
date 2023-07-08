package it.avanscoperta.mbuti.domain.LandingPageTest;

import it.avanscoperta.mbuti.domain.LandingPage;
import org.junit.jupiter.api.Test;

import java.net.MalformedURLException;
import java.net.URL;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class LandingPageTest {


    @Test
    void can_create_a_landing_page() throws MalformedURLException {
        String label = "Test Landing Page";
        URL url = new URL("https://eventstorming.com");
        LandingPage landingPage = new LandingPage(
                label, url
        );

        assertNotNull(landingPage);
    }

    @Test
    void can_add_a_traffic_stream() {

    }
}
