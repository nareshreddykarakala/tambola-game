package com.tambola.rule;

import com.tambola.model.NumberAnnouncement;
import com.tambola.model.Ticket;

public interface WinningRule {
    boolean isSatisfied(Ticket ticket, NumberAnnouncement announcement);
}
