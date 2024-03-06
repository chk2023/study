package com.ohgiraffers.mvc.actor.model.dto;

public class ActorDTO {
    private String actorId;
    private String firstName;
    private String lastName;
    private String lastUpdate;
    private String filmId;
    private String title;

    public ActorDTO() {
    }

    public ActorDTO(String actorId, String firstName, String lastName,
                    String lastUpdate, String filmId, String title) {
        this.actorId = actorId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.lastUpdate = lastUpdate;
        this.filmId = filmId;
        this.title = title;
    }

    public String getActorId() {
        return actorId;
    }

    public void setActorId(String actorId) {
        this.actorId = actorId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(String lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public String getFilmId() {
        return filmId;
    }

    public void setFilmId(String filmId) {
        this.filmId = filmId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "ActorDTO{" +
                "actorId='" + actorId + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", lastUpdate='" + lastUpdate + '\'' +
                ", filmId='" + filmId + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
