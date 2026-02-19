package com.tambola.rule;

import com.tambola.model.NumberAnnouncement;
import com.tambola.model.Ticket;

import java.util.Set;

public class EarlyFiveRule extends AbstractWinningRule {

    @Override
    protected boolean isSatisfiedNow(Ticket ticket, Set<Integer> announced) {

        long matchedCount = ticket.getAllNumbers().stream()
                .filter(announced::contains)
                .count();

        return matchedCount >= 5;
    }
}
