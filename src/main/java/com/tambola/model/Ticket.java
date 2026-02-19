package com.tambola.model;

import java.util.List;

public class Ticket {
    private final List<List<Integer>> rows;

    public Ticket(List<List<Integer>> rows) {
        this.rows = rows;
    }

    public List<Integer> getTopRow() {
        return rows.get(0);
    }
}
