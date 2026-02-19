package com.tambola.rule;

import com.tambola.model.NumberAnnouncement;
import com.tambola.model.Ticket;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TopRowRuleTest {

    private final TopRowRule rule = new TopRowRule();

    private static Ticket getTicket() {
        return new Ticket(List.of(
                List.of(4, 16, 48, 63, 76),
                List.of(7, 23, 38, 52, 80),
                List.of(9, 25, 56, 64, 83)
        ));
    }

    @Test
    void shouldAcceptWhenTopRowJustCompleted() {

        Ticket ticket = getTicket();

        NumberAnnouncement announcement =
                new NumberAnnouncement(List.of(
                90, 4, 46, 63, 89, 16, 76, 48
        ));

        assertTrue(rule.isSatisfied(ticket, announcement));
    }

    @Test
    void shouldRejectIfTopRowCompletedBeforeLastNumber() {

        Ticket ticket = getTicket();

        NumberAnnouncement announcement =
                new NumberAnnouncement(List.of(
                        4, 63, 16, 76, 48, 12
                ));

        assertFalse(rule.isSatisfied(ticket, announcement));
    }

    @Test
    void shouldRejectIfLastNumberNotPartOfTopRow() {

        Ticket ticket = getTicket();

        NumberAnnouncement announcement =
                new NumberAnnouncement(List.of(
                        4, 63, 16, 76, 99
                ));

        assertFalse(rule.isSatisfied(ticket, announcement));
    }
    @Test
    void shouldRejectIfTopRowIncomplete() {

        Ticket ticket = new Ticket(List.of(
                List.of(4, 16, 48, 63, 76),
                List.of(7, 23, 38, 52, 80),
                List.of(9, 25, 56, 64, 83)
        ));

        NumberAnnouncement announcement =
                new NumberAnnouncement(List.of(
                        4, 63, 16
                ));

        assertFalse(rule.isSatisfied(ticket, announcement));
    }

}