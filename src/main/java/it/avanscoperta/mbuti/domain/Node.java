package it.avanscoperta.mbuti.domain;

import java.time.Duration;
import java.util.Collection;

/**
 * TODO: maybe an interface?
 */
public abstract class Node {
    protected String label;
    public abstract void tick(int round, Duration duration, Pipeline pipeline, SimulationResult results);

    public abstract boolean isTerminal();

    public abstract Collection<TrafficStream> inputStreams();

    public String getLabel() {
        return label;
    }

    public abstract void addOutput(ConversionRate conversionRate, Node destination);
}
