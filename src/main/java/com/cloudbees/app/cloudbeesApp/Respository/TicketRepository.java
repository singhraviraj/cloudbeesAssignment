package com.cloudbees.app.cloudbeesApp.Respository;

import com.cloudbees.app.cloudbeesApp.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {
    Ticket findByEmail(String email);
    List<Ticket> findAllBySection(String section);
}
