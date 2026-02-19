package com.tambola.rule;

import com.tambola.model.NumberAnnouncement;
import com.tambola.model.Ticket;

import java.util.List;
import java.util.Set;

public class BottomRowRule implements WinningRule {
    @Override
    public boolean isSatisfied(Ticket ticket, NumberAnnouncement announcement) {
        List<Integer> row = ticket.getBottomRow();
        Set<Integer> announced = announcement.getAnnouncedSet();
        Set<Integer> beforeLast = announcement.getAnnouncedBeforeLast();
        Integer last = announcement.getLastNumber();

        return announced.containsAll(row)
                && !beforeLast.containsAll(row)
                && row.contains(last);
    }
}
