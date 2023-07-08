package it.avanscoperta.mbuti.domain;

import java.net.URL;
import java.time.Duration;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class LandingPage extends Node {
    private final String label;
    private final URL url;

    Map<String, TrafficStream> incomingTrafficStreams = new HashMap<>();
    Map<String, TrafficStream> outputTrafficStreams = new HashMap<>();

    public LandingPage(String label, URL url) {
        this.label = label;
        this.url = url;
    }

    public void addIncomingTrafficStream(String label, TrafficStream trafficStream) {
        incomingTrafficStreams.put(label, trafficStream);

    }

    public Collection<TrafficStream> incomingTrafficStreams() {
        return incomingTrafficStreams.values();
    }

    @Override
    public void tick(Duration duration, Pipeline pipeline) {

    }

    @Override
    public boolean isTerminal() {
        return false;
    }
}
