package com.tambola.service;

import com.tambola.model.GameType;
import com.tambola.model.NumberAnnouncement;
import com.tambola.model.Ticket;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ClaimValidatorTest {

    @Test
    void shouldRejectIfPatternNotComplete() {

        Ticket ticket = new Ticket(List.of(
                List.of(4, 16, 48),
                List.of(),
                List.of()
        ));

        ClaimValidator validator = new ClaimValidator();

        boolean result = validator.validate(
                ticket,
                new NumberAnnouncement(List.of(4, 16)),
                GameType.TOP_ROW
        );

        assertFalse(result);
    }

}