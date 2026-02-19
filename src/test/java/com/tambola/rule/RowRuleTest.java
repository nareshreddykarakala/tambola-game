package com.tambola.rule;

import com.tambola.model.NumberAnnouncement;
import com.tambola.model.Ticket;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RowRuleTest {
    private static Ticket getTicket() {
        return new Ticket(List.of(
                List.of(4, 16, 48, 63, 76),
                List.of(7, 23, 38, 52, 80),
                List.of(9, 25, 56, 64, 83)
        ));
    }

    @Nested
    class TopRuleTest {
        private final RowRule top_rule = new RowRule(Ticket::getTopRow);


        @Test
        void shouldAcceptWhenTopRowJustCompleted() {

            Ticket ticket = getTicket();

            NumberAnnouncement announcement =
                    new NumberAnnouncement(List.of(
                            90, 4, 46, 63, 89, 16, 76, 48
                    ));

            assertTrue(top_rule.isSatisfied(ticket, announcement));
        }

        @Test
        void shouldRejectIfTopRowCompletedBeforeLastNumber() {

            Ticket ticket = getTicket();

            NumberAnnouncement announcement =
                    new NumberAnnouncement(List.of(
                            4, 63, 16, 76, 48, 12
                    ));

            assertFalse(top_rule.isSatisfied(ticket, announcement));
        }

        @Test
        void shouldRejectIfLastNumberNotPartOfTopRow() {

            Ticket ticket = getTicket();

            NumberAnnouncement announcement =
                    new NumberAnnouncement(List.of(
                            4, 63, 16, 76, 99
                    ));

            assertFalse(top_rule.isSatisfied(ticket, announcement));
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

            assertFalse(top_rule.isSatisfied(ticket, announcement));
        }
    }

    @Nested
    class MiddleRowRuleTest {
        private final RowRule middlerow_rule = new RowRule(Ticket::getMiddleRow);

        @Test
        void shouldAcceptWhenMiddleRowCompletedNow() {

            Ticket ticket = getTicket();

            NumberAnnouncement announcement =
                    new NumberAnnouncement(List.of(
                            7, 23, 38, 52, 80
                    ));

            assertTrue(middlerow_rule.isSatisfied(ticket, announcement));
        }

        @Test
        void shouldRejectIfMiddleRowCompletedEarlier() {

            Ticket ticket = getTicket();

            NumberAnnouncement announcement =
                    new NumberAnnouncement(List.of(
                            7, 23, 38, 52, 80, 12
                    ));

            assertFalse(middlerow_rule.isSatisfied(ticket, announcement));
        }

        @Test
        void shouldRejectIfIncomplete() {

            Ticket ticket = getTicket();

            NumberAnnouncement announcement =
                    new NumberAnnouncement(List.of(
                            7, 23
                    ));

            assertFalse(middlerow_rule.isSatisfied(ticket, announcement));
        }
    }

    @Nested
    class BottomRowRuleTest {
        private final RowRule bottom_rule = new RowRule(Ticket::getBottomRow);

        @Test
        void shouldAcceptWhenBottomRowCompletedNow() {

            Ticket ticket = getTicket();

            NumberAnnouncement announcement =
                    new NumberAnnouncement(List.of(
                            9, 25, 56, 64, 83
                    ));

            assertTrue(bottom_rule.isSatisfied(ticket, announcement));
        }

        @Test
        void shouldRejectIfBottomRowCompletedEarlier() {

            Ticket ticket = getTicket();

            NumberAnnouncement announcement =
                    new NumberAnnouncement(List.of(
                            9, 25, 56, 64, 83, 11
                    ));

            assertFalse(bottom_rule.isSatisfied(ticket, announcement));
        }
    }

    @Test
    void should_return_false_if_row_was_already_completed_before_last_number() {

        Ticket ticket = getTicket();

        NumberAnnouncement announcement =
                new NumberAnnouncement(List.of(1, 2, 3, 4, 5, 99));

        RowRule rule = new RowRule(Ticket::getTopRow);

        assertFalse(rule.isSatisfied(ticket, announcement));
    }

}