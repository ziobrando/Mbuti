package it.avanscoperta.mbuti.domain;

import java.util.ArrayList;
import java.util.List;

public class SimulationResult {
    List<String> results = new ArrayList<>();

    public void append(String resultString) {
        results.add(resultString);
    }
}
