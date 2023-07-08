package it.avanscoperta.mbuti.domain;

import org.junit.jupiter.api.Test;

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
    void can_run_a_simulation() {
        Pipeline pipeline = Pipeline.createEmpty();
        pipeline.runSimulation(5, Duration.of(5, ChronoUnit.DAYS));
        assertEquals("Empty pipeline", pipeline.getResults());
    }
}
