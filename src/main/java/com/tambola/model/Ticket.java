package com.tambola.model;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Ticket {
    private final List<List<Integer>> rows;

    public Ticket(List<List<Integer>> rows) {
        if(rows.size() != 3) {
            throw new IllegalArgumentException("A ticket must have exactly 3 rows");
        }
        this.rows = rows;
    }

    public List<Integer> getTopRow() {
        return rows.get(0);
    }
    public List<Integer> getMiddleRow() {
        return rows.get(1);
    }
    public List<Integer> getBottomRow() {
        return rows.get(2);
    }


    public Set<Integer> getAllNumbers() {
        return rows.stream()
                .flatMap(Collection::stream)
                .collect(Collectors.toSet());
    }
}
