package com.mns;

import java.util.ArrayList;
import java.util.List;

public class AdoptionEvent {
    private List<IAdoptable> participants;

    public AdoptionEvent() {
        this.participants = new ArrayList<>();
    }

    public void hostEvent() {
        System.out.println("Adoption event hosted!");
    }

    public void registerParticipant(IAdoptable participant) {
        participants.add(participant);
        System.out.println("Participant registered for the adoption event.");
    }
}
