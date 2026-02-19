package com.tambola.rule;

import com.tambola.model.NumberAnnouncement;
import com.tambola.model.Ticket;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FullHouseRuleTest {
    @Test
    void should_return_true_when_all_numbers_completed() {

        Ticket ticket = new Ticket(List.of(
                List.of(1, 2, 3),
                List.of(4, 5, 6),
                List.of(7, 8, 9)
        ));

        NumberAnnouncement announcement = new NumberAnnouncement(
                List.of(1, 2, 3, 4, 5, 6, 7, 8, 9)
        );

        FullHouseRule rule = new FullHouseRule();

        assertTrue(rule.isSatisfied(ticket, announcement));
    }
    @Test
    void should_return_false_if_full_house_was_already_completed_before_last_number() {

        Ticket ticket = new Ticket(List.of(
                List.of(1, 2, 3),
                List.of(4, 5, 6),
                List.of(7, 8, 9)
        ));

        // Full house already complete at 9
        // 99 is extra irrelevant number
        NumberAnnouncement announcement = new NumberAnnouncement(
                List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 99)
        );

        FullHouseRule rule = new FullHouseRule();

        assertFalse(rule.isSatisfied(ticket, announcement));
    }
    @Test
    void should_return_false_if_not_all_numbers_matched() {

        Ticket ticket = new Ticket(List.of(
                List.of(1, 2, 3),
                List.of(4, 5, 6),
                List.of(7, 8, 9)
        ));

        // Missing 9
        NumberAnnouncement announcement = new NumberAnnouncement(
                List.of(1, 2, 3, 4, 5, 6, 7, 8)
        );

        FullHouseRule rule = new FullHouseRule();

        assertFalse(rule.isSatisfied(ticket, announcement));
    }

}