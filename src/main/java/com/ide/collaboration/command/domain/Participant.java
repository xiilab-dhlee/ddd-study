package com.ide.collaboration.command.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Embeddable
public class Participant {

    @Column(name = "user_id")
    private String userId;

    @Column(name = "user_name")
    private String userName;

    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private ParticipantRole role;

    protected Participant() {
    }

    public Participant(String userId, String userName, ParticipantRole role) {
        this.userId = userId;
        this.userName = userName;
        this.role = role;
    }

    public String getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public ParticipantRole getRole() {
        return role;
    }

    public enum ParticipantRole {
        OWNER, EDITOR, VIEWER
    }
}

