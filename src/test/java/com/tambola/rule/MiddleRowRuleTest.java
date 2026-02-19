package com.tambola.rule;

import com.tambola.model.NumberAnnouncement;
import com.tambola.model.Ticket;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MiddleRowRuleTest {

    private final MiddleRowRule rule = new MiddleRowRule();

    @Test
    void shouldAcceptWhenMiddleRowCompletedNow() {

        Ticket ticket = validTicket();

        NumberAnnouncement announcement =
                new NumberAnnouncement(List.of(
                        7, 23, 38, 52, 80
                ));

        assertTrue(rule.isSatisfied(ticket, announcement));
    }

    @Test
    void shouldRejectIfMiddleRowCompletedEarlier() {

        Ticket ticket = validTicket();

        NumberAnnouncement announcement =
                new NumberAnnouncement(List.of(
                        7, 23, 38, 52, 80, 12
                ));

        assertFalse(rule.isSatisfied(ticket, announcement));
    }

    @Test
    void shouldRejectIfIncomplete() {

        Ticket ticket = validTicket();

        NumberAnnouncement announcement =
                new NumberAnnouncement(List.of(
                        7, 23
                ));

        assertFalse(rule.isSatisfied(ticket, announcement));
    }

    private Ticket validTicket() {
        return new Ticket(List.of(
                List.of(4, 16, 48, 63, 76),
                List.of(7, 23, 38, 52, 80),
                List.of(9, 25, 56, 64, 83)
        ));
    }
}