package com.tambola.rule;

import com.tambola.model.NumberAnnouncement;
import com.tambola.model.Ticket;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TopRowRule implements WinningRule {
    @Override
    public boolean isSatisfied(Ticket ticket, NumberAnnouncement announcement) {
        List<Integer> topRow = ticket.getTopRow();
        Set<Integer> announcedSet = announcement.getAnnouncedSet();
        Set<Integer> announcedBeforeLast = announcement.getAnnouncedBeforeLast();
        Integer lastNumber = announcement.getLastNumber();
        return announcedSet.containsAll(topRow)
                && !announcedBeforeLast.containsAll(topRow)
                && topRow.contains(lastNumber);
    }
}
