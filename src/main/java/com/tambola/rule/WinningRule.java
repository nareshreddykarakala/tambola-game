package com.tambola.rule;

import com.tambola.model.Ticket;

import java.util.List;

public interface WinningRule {
    boolean isSatisfied(Ticket ticket, List<Integer> announcement);
}
