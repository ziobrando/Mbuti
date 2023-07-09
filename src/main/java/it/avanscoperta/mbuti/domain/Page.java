package it.avanscoperta.mbuti.domain;

import java.net.URL;
import java.time.Duration;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Page extends Node {
    private final String label;
    private final URL url;

    Map<String, TrafficStream> incomingTrafficStreams = new HashMap<>();
    Map<String, TrafficStream> outputTrafficStreams = new HashMap<>();

    public Page(String label, URL url) {
        this.label = label;
        this.url = url;
    }

    public void addIncomingTrafficStream(String label, TrafficStream trafficStream) {
        incomingTrafficStreams.put(label, trafficStream);

    }

    @Override
    public void tick(Duration duration, Pipeline pipeline) {

    }

    @Override
    public boolean isTerminal() {
        return false;
    }

    @Override
    public Collection<TrafficStream> inputStreams() {
        return incomingTrafficStreams.values();
    }

    public Page withIncomingTraffic(String label, TrafficStream incomingTraffic) {
        this.incomingTrafficStreams.put(label, incomingTraffic);
        return this;
    }
}
