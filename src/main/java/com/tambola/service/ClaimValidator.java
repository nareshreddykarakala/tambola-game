package com.tambola.service;

import com.tambola.model.GameType;
import com.tambola.model.NumberAnnouncement;
import com.tambola.model.Ticket;

import java.util.List;

public class ClaimValidator {

    public boolean validate(Ticket ticket, List<Integer> announced, GameType gameType) {
       return gameType.validate(
                ticket,
                new NumberAnnouncement(announced)
        );
    }
}
