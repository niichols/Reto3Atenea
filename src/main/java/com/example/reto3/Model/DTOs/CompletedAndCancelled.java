package com.example.reto3.Model.DTOs;

public class CompletedAndCancelled {

    private Long completed;
    private Long cancelled;

    public CompletedAndCancelled(Long completed, Long cancelled) {
        this.completed = completed;
        this.cancelled = cancelled;
    }

    public Long getCompleted() {
        return completed;
    }

    public void setClompleted(Long clompleted) {
        this.completed = clompleted;
    }

    public Long getCancelled() {
        return cancelled;
    }

    public void setCancelled(Long cancelled) {
        this.cancelled = cancelled;
    }
}
