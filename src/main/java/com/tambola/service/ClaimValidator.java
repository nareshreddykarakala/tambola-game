package com.tambola.service;

import com.tambola.model.GameType;
import com.tambola.model.NumberAnnouncement;
import com.tambola.model.Ticket;

public class ClaimValidator {

    public boolean validate(Ticket ticket, NumberAnnouncement announced, GameType gameType) {
       return gameType.validate(
                ticket,
                announced
        );
    }
}
