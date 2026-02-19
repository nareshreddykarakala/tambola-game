package com.tambola.integration;

import com.tambola.model.GameType;
import com.tambola.model.NumberAnnouncement;
import com.tambola.model.Ticket;
import com.tambola.service.ClaimValidator;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TambolaIntegrationTest {

    private final ClaimValidator validator = new ClaimValidator();

    private Ticket sampleTicket() {
        return new Ticket(List.of(
                List.of(1, 2, 3),
                List.of(4, 5, 6),
                List.of(7, 8, 9)
        ));
    }

    // ----------------------------
    // TOP ROW
    // ----------------------------

    @Test
    void should_validate_top_row_successfully() {
        NumberAnnouncement announcement =
                new NumberAnnouncement(List.of(1, 2, 3));

        assertTrue(validator.validate(
                sampleTicket(),
                announcement,
                GameType.TOP_ROW
        ));
    }

    @Test
    void should_reject_top_row_if_already_completed_before() {
        NumberAnnouncement announcement =
                new NumberAnnouncement(List.of(1, 2, 3, 99));

        assertFalse(validator.validate(
                sampleTicket(),
                announcement,
                GameType.TOP_ROW
        ));
    }

    // ----------------------------
    // EARLY FIVE
    // ----------------------------

    @Test
    void should_validate_early_five() {
        NumberAnnouncement announcement =
                new NumberAnnouncement(List.of(1, 2, 3, 4, 5));

        assertTrue(validator.validate(
                sampleTicket(),
                announcement,
                GameType.EARLY_FIVE
        ));
    }

    @Test
    void should_reject_early_five_if_less_than_five() {
        NumberAnnouncement announcement =
                new NumberAnnouncement(List.of(1, 2, 3, 4));

        assertFalse(validator.validate(
                sampleTicket(),
                announcement,
                GameType.EARLY_FIVE
        ));
    }

    // ----------------------------
    // FULL HOUSE
    // ----------------------------

    @Test
    void should_validate_full_house() {
        NumberAnnouncement announcement =
                new NumberAnnouncement(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9));

        assertTrue(validator.validate(
                sampleTicket(),
                announcement,
                GameType.FULL_HOUSE
        ));
    }

    @Test
    void should_reject_full_house_if_incomplete() {
        NumberAnnouncement announcement =
                new NumberAnnouncement(List.of(1, 2, 3, 4, 5, 6, 7, 8));

        assertFalse(validator.validate(
                sampleTicket(),
                announcement,
                GameType.FULL_HOUSE
        ));
    }
}

