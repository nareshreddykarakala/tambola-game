package com.tambola.rule;

import com.tambola.model.Ticket;

import java.util.List;
import java.util.Set;
import java.util.function.Function;

public class RowRule extends AbstractWinningRule {
    private final Function<Ticket, List<Integer>> rowExtractor;

    public RowRule(Function<Ticket, List<Integer>> rowExtractor) {
        this.rowExtractor = rowExtractor;
    }

    @Override
    protected boolean isSatisfiedNow(Ticket ticket, Set<Integer> announced) {
        return announced.containsAll(rowExtractor.apply(ticket));
    }
}
