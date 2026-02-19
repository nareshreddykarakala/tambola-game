package com.tambola.rule;

import com.tambola.model.Ticket;

import java.util.Set;

public class FullHouseRule extends AbstractWinningRule {

    @Override
    protected boolean isSatisfiedNow(Ticket ticket, Set<Integer> announced) {
        return announced.containsAll(ticket.getAllNumbers());
    }
}
