package com.example.reto3.Model.DTOs;

public class CompletedAndCancelled {

    private Long clomplted;
    private Long cancelled;

    public CompletedAndCancelled(Long clomplted, Long cancelled) {
        this.clomplted = clomplted;
        this.cancelled = cancelled;
    }

    public Long getClomplted() {
        return clomplted;
    }

    public void setClomplted(Long clomplted) {
        this.clomplted = clomplted;
    }

    public Long getCancelled() {
        return cancelled;
    }

    public void setCancelled(Long cancelled) {
        this.cancelled = cancelled;
    }
}
