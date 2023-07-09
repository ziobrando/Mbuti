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
    @DisplayName("An empty pipeline will be reported")
    void an_empty_pipeline_will_be_reported() {
        Pipeline pipeline = Pipeline.createEmpty();
        pipeline.runSimulation(5, Duration.of(5, ChronoUnit.DAYS));
        assertEquals("Empty pipeline", pipeline.getResults());
    }

    @Test
    void can_run_a_simulation() throws MalformedURLException {
        Pipeline pipeline = Pipeline.createEmpty();
        TrafficStream incomingTraffic = new TrafficStream(35);
        URL terminalURL = new URL("https://www.avanscoperta.it/checkout");
        Node terminal = new Page("Terminal", terminalURL).withIncomingTraffic("Organic", incomingTraffic);
        pipeline.addNode(terminal);

        pipeline.runSimulation(2, Duration.of(1, ChronoUnit.DAYS));
    }

}
