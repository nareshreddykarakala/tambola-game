package com.tambola.rule;

import com.tambola.model.NumberAnnouncement;
import com.tambola.model.Ticket;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BottomRowRuleTest {
    private final BottomRowRule rule = new BottomRowRule();
    private Ticket validTicket() {
        return new Ticket(List.of(
                List.of(4, 16, 48, 63, 76),
                List.of(7, 23, 38, 52, 80),
                List.of(9, 25, 56, 64, 83)
        ));
    }
    @Test
    void shouldAcceptWhenBottomRowCompletedNow() {

        Ticket ticket = validTicket();

        NumberAnnouncement announcement =
                new NumberAnnouncement(List.of(
                        9, 25, 56, 64, 83
                ));

        assertTrue(rule.isSatisfied(ticket, announcement));
    }
    @Test
    void shouldRejectIfBottomRowCompletedEarlier() {

        Ticket ticket = validTicket();

        NumberAnnouncement announcement =
                new NumberAnnouncement(List.of(
                        9, 25, 56, 64, 83, 11
                ));

        assertFalse(rule.isSatisfied(ticket, announcement));
    }
}