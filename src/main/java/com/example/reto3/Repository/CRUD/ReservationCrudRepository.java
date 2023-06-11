package com.example.reto3.Repository.CRUD;

import com.example.reto3.Model.Reservation;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Date;

public interface ReservationCrudRepository extends CrudRepository <Reservation, Integer> {

    //Reporte 1
    // SELECT * FROM RESERVATION WHERE STARTDATE AFTER fechaA AND DEVOLUTIONDATE BEFORE fechaB

    public List<Reservation> findAllByStartDateAfterAndDevolutionDateBefore(Date fechaA, Date fechaB);

    //Reporte 2
    // SELECT Reservation WHERE status = "valorNecesite"
    public List<Reservation> findAllByStatus(String status);

    //Reporte 3
    // SELECT client, COUNT(client) FROM Reservation GROUP BY client ORDEN BY COUNT(client) DESC;
    // Lista parejas de 2 valores
    @Query("SELECT c.client, COUNT(c.client) FROM Reservation AS c GROUP BY c.client ORDER BY COUNT(c.client) DESC")
    public List<Object[]> getTotalReservationsByClient();

}
