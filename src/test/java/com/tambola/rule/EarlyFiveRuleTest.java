package com.tambola.rule;

import com.tambola.model.NumberAnnouncement;
import com.tambola.model.Ticket;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EarlyFiveRuleTest {
    @Test
    void should_return_true_when_first_five_numbers_completed() {

        Ticket ticket = new Ticket(List.of(
                List.of(1, 2, 3, 4, 5),
                List.of(6, 7, 8, 9, 10),
                List.of(11, 12, 13, 14, 15)
        ));

        NumberAnnouncement announcement = new NumberAnnouncement(
                List.of(1, 2, 3, 4, 6)
        );

        EarlyFiveRule rule = new EarlyFiveRule();

        assertTrue(rule.isSatisfied(ticket, announcement));
    }
    @Test
    void should_return_false_if_early_five_was_already_completed_before_last_number() {

        Ticket ticket = new Ticket(List.of(
                List.of(1, 2, 3, 4, 5),
                List.of(6, 7, 8, 9, 10),
                List.of(11, 12, 13, 14, 15)
        ));

        // First 5 numbers complete early five
        // 99 is new last number but does not change early five status
        NumberAnnouncement announcement =
                new NumberAnnouncement(List.of(1, 2, 3, 4, 5, 99));

        EarlyFiveRule rule = new EarlyFiveRule();

        assertFalse(rule.isSatisfied(ticket, announcement));
    }


}