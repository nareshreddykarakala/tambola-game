package com.tambola.rule;

import com.tambola.model.NumberAnnouncement;
import com.tambola.model.Ticket;

import java.util.Set;

public abstract class AbstractWinningRule implements WinningRule {
    @Override
    public boolean isSatisfied(Ticket ticket, NumberAnnouncement announcement) {
        return isSatisfiedNow(ticket, announcement.getAnnouncedSet())
                && !isSatisfiedNow(ticket, announcement.getAnnouncedBeforeLast());
    }
    protected abstract boolean isSatisfiedNow(Ticket ticket, Set<Integer> announced);
}
