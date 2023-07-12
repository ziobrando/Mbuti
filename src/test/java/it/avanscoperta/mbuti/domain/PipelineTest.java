package it.avanscoperta.mbuti.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.time.temporal.ChronoUnit;

import static org.junit.jupiter.api.Assertions.*;

public class PipelineTest {


    @Test
    void can_create_an_empty_pipeline() {
        Pipeline pipeline = Pipeline.createEmpty();
        assertNotNull(pipeline);
    }

    @Test
    void can_build_a_pipeline() throws MalformedURLException {
        Page landingPage = new Page("Landing Page", new URL("http://funnel.com/home"));
        Page productPage = new Page("Product Page", new URL("http://funnel.com/product"));

        Pipeline pipeline = Pipeline.createEmpty();
        pipeline.addNode(landingPage);
        pipeline.addNode(productPage);
        pipeline.connect(landingPage, productPage, new ConversionRate(0.25));

        assertEquals(2, pipeline.connectedNodes.size());

    }

    @Test
    @DisplayName("An empty pipeline will be reported")
    void an_empty_pipeline_will_be_reported() {
        Pipeline pipeline = Pipeline.createEmpty();
        pipeline.runSimulation(5, Duration.of(5, ChronoUnit.DAYS));
        assertTrue(pipeline.getResults().results.contains("Empty pipeline"));
    }

    @Test
    void can_run_a_simulation() throws MalformedURLException {
        Pipeline pipeline = Pipeline.createEmpty();
        TrafficStream incomingTraffic = new TrafficStream(35);
        URL terminalURL = new URL("https://www.avanscoperta.it/checkout");
        Node terminal = new Page("Terminal", terminalURL).withIncomingTraffic("Organic", incomingTraffic);
        pipeline.addNode(terminal);

        pipeline.runSimulation(2, Duration.of(1, ChronoUnit.DAYS));

        assertTrue(pipeline.getResults().results.contains("SIMULATION:"));
    }

}
