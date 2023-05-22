package com.example.reto3.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import javax.xml.crypto.Data;
import java.util.Date;

@Entity
@Table (name = "reservation")
public class Reservation {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer idReservation;
    private Date starDate;
    private Date devolutionDate;
    private String status = "created";

    //Carros
    @ManyToOne
    @JoinColumn(name="carId")
    @JsonIgnoreProperties("reservations")
    private Car car;

    // muchos a uno Clientes
    @ManyToOne
    @JoinColumn(name="clientId")
    @JsonIgnoreProperties({"reservations", "messages"})
    private Client client;

    //uno a uno score Puntajes
    @OneToOne
    @JsonIgnoreProperties("reservation")
    private Score score;

    // Metodos Getter and Setter
    public Integer getIdReservation() {
        return idReservation;
    }

    public void setIdReservation(Integer idReservation) {
        this.idReservation = idReservation;
    }

    public Date getStarDate() {
        return starDate;
    }

    public void setStarDate(Date starDate) {
        this.starDate = starDate;
    }

    public Date getDevolutionDate() {
        return devolutionDate;
    }

    public void setDevolutionDate(Date devolutionDate) {
        this.devolutionDate = devolutionDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Score getScore() {
        return score;
    }

    public void setScore(Score score) {
        this.score = score;
    }
}
