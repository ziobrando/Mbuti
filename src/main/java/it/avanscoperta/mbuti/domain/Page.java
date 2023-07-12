package it.avanscoperta.mbuti.domain;

import java.net.URL;
import java.time.Duration;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Page extends Node {
    private final URL url;

    Map<String, TrafficStream> incomingTrafficStreams = new HashMap<>();
    Map<String, TrafficLink> outputTrafficStreams = new HashMap<String, TrafficLink>();

    public Page(String label, URL url) {
        this.label = label;
        this.url = url;
    }

    public void addIncomingTrafficStream(String label, TrafficStream trafficStream) {
        incomingTrafficStreams.put(label, trafficStream);
    }

    public void addOutput(Node destination, ConversionRate conversionRate) {

    }


    @Override
    public void tick(int round, Duration duration, Pipeline pipeline, SimulationResult results) {
        throw new RuntimeException("Not implemented yet");
    }

    @Override
    public boolean isTerminal() {
        return false;
    }

    @Override
    public Collection<TrafficStream> inputStreams() {
        return incomingTrafficStreams.values();
    }

    @Override
    public void addOutput(ConversionRate conversionRate, Node destination) {
        this.outputTrafficStreams.put(
                destination.getLabel(),
                new TrafficLink(this, conversionRate, destination)
        );
    }

    public Page withIncomingTraffic(String label, TrafficStream incomingTraffic) {
        this.incomingTrafficStreams.put(label, incomingTraffic);
        return this;
    }
}
