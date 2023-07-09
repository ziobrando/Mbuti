package it.avanscoperta.mbuti.domain;

import java.time.Duration;
import java.util.Collection;

/**
 * TODO: maybe an interface?
 */
public abstract class Node {
    public abstract void tick(Duration duration, Pipeline pipeline);

    public abstract boolean isTerminal();

    public abstract Collection<TrafficStream> inputStreams();
}
