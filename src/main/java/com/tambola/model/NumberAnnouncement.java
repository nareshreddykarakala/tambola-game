package com.tambola.model;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NumberAnnouncement {

    private final List<Integer> announcedNumbers;

    public NumberAnnouncement(List<Integer> announcedNumbers) {
        this.announcedNumbers = announcedNumbers;
    }

    public Set<Integer> getAnnouncedSet() {
        return new HashSet<>(announcedNumbers);
    }

    public Integer getLastNumber() {
        if (announcedNumbers.isEmpty())
            throw new IllegalStateException("No numbers announced");
        return announcedNumbers.get(announcedNumbers.size() - 1);
    }

    public Set<Integer> getAnnouncedBeforeLast() {
        if (announcedNumbers.size() <= 1)
            return Collections.emptySet();
        return new HashSet<>(announcedNumbers.subList(0, announcedNumbers.size() - 1));
    }
}

