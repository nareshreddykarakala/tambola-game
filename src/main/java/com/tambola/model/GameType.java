package com.tambola.model;

import com.tambola.rule.TopRowRule;
import com.tambola.rule.WinningRule;

public enum GameType {
    TOP_ROW(new TopRowRule());

    private final WinningRule rule;

    GameType(WinningRule rule) {
        this.rule = rule;
    }

    public boolean validate(Ticket ticket,
                            NumberAnnouncement announcement) {
        return rule.isSatisfied(ticket, announcement);
    }
}
