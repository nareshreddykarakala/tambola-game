package com.tambola.model;

import com.tambola.rule.*;

public enum GameType {
    TOP_ROW(new RowRule(Ticket::getTopRow)),
    MIDDLE_ROW(new RowRule(Ticket::getMiddleRow)),
    BOTTOM_ROW(new RowRule(Ticket::getBottomRow)),
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
