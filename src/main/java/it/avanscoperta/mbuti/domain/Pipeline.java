package it.avanscoperta.mbuti.domain;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Pipeline {

    final static Logger logger = LoggerFactory.getLogger(Pipeline.class);
    String results = "";
    Map<Node, List<TrafficStream>> connectedNodes = new HashMap<>();
    public static Pipeline createEmpty() {
        return new Pipeline();
    }

    public void runSimulation(int rounds, Duration roundDuration) {
        // for every destination... tick() letting the node pull visitors from the previous step.
        reset();

        if(connectedNodes.isEmpty()) { results = "Empty pipeline"; }

        connectedNodes.keySet()
                .stream()
                .filter(Node::isTerminal)
                .forEach(
                        (node) -> node.tick(roundDuration, this)
                );
    }

    private void reset() {
        this.results = "";
    }

    public String getResults() {
        return results;
    }
}
