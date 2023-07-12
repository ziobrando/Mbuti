package it.avanscoperta.mbuti.domain;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Pipeline {

    final static Logger logger = LoggerFactory.getLogger(Pipeline.class);
    SimulationResult results = new SimulationResult();
    Map<String, Node> connectedNodes = new HashMap<>();

    public static Pipeline createEmpty() {
        return new Pipeline();
    }

    public void runSimulation(int rounds, Duration roundDuration) {
        // for every destination... tick() letting the node pull visitors from the previous step.
        reset();
        for (int round = 1; round <= rounds; round++) {
            if(connectedNodes.isEmpty()) { results.append("Empty pipeline"); }
            results.append("SIMULATION:");
            int finalRound = round;
            connectedNodes.values()
                    .stream()
                    .filter(Node::isTerminal)
                    .forEach(
                            (node) -> node.tick(finalRound, roundDuration, this, results)
                    );
        }

    }

    private void reset() {
        this.results = new SimulationResult();
    }

    public SimulationResult getResults() {
        return results;
    }

    public void addNode(Node node) {
        connectedNodes.put(node.getLabel(), node);
    }

    public void connect(Node origin, Node destination, ConversionRate conversionRate) {
        Node node = connectedNodes.get(origin.getLabel());

        node.addOutput(conversionRate, destination);
    }
}
