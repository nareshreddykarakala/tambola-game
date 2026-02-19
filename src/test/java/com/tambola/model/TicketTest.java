package com.tambola.model;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class TicketTest {

    @Test
    void shouldReturnRowCorrectly() {
        Ticket ticket = new Ticket(List.of(
                List.of(4, 16, 48),
                List.of(5, 17, 49),
                List.of(6, 18, 50)
        ));

        assertEquals(List.of(4, 16, 48), ticket.getTopRow());
        assertEquals(List.of(5, 17, 49), ticket.getMiddleRow());
        assertEquals(List.of(6, 18, 50), ticket.getBottomRow());
    }

    @Test
    void shouldThrowExceptionWhenRowsNotThree() {
        List<List<Integer>> rows = List.of(
                List.of(1, 2, 3)
        );

        assertThrows(IllegalArgumentException.class,
                () -> new Ticket(rows));
    }

    @Test
    void shouldReturnEmptyListIfTopRowIsEmpty() {
        Ticket ticket = new Ticket(List.of(
                List.of(),
                List.of(5, 17, 49),
                List.of(6, 18, 50)
        ));

        assertEquals(List.of(), ticket.getTopRow());
    }

    @Test
    void shouldReturnAllNumbers() {
        Ticket ticket = validTicket();

        Set<Integer> all = ticket.getAllNumbers();

        assertEquals(Set.of(1, 2, 3, 4, 5, 6, 7, 8, 9), all);
    }

    private Ticket validTicket() {
        return new Ticket(List.of(
                List.of(1, 2, 3),
                List.of(4, 5, 6),
                List.of(7, 8, 9)
        ));
    }

}