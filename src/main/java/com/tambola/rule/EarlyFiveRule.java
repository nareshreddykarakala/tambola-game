package com.tambola.rule;

import com.tambola.model.NumberAnnouncement;
import com.tambola.model.Ticket;

public class EarlyFiveRule implements WinningRule {
    @Override
    public boolean isSatisfied(Ticket ticket, NumberAnnouncement announcement) {
        return false;
    }
}
