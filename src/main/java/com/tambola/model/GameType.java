package com.tambola.model;

import com.tambola.rule.*;

public enum GameType {
    TOP_ROW(new TopRowRule()),
    MIDDLE_ROW(new MiddleRowRule()),
    BOTTOM_ROW(new BottomRowRule()),
    EARLY_FIVE(new EarlyFiveRule()),
    FULL_HOUSE(new FullHouseRule());

    private final WinningRule rule;

    GameType(WinningRule rule) {
        this.rule = rule;
    }

    public boolean validate(Ticket ticket,
                            NumberAnnouncement announcement) {
        return rule.isSatisfied(ticket, announcement);
    }
}
