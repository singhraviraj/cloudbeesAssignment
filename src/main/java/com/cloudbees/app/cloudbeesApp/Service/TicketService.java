package com.cloudbees.app.cloudbeesApp.Service;

import com.cloudbees.app.cloudbeesApp.entity.Ticket;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TicketService {

    public Ticket purchaseTicket(Ticket ticket);
    public Ticket getReceipt(String email);
    public List<Ticket> getUsersBySection(String section);
    public void removeUser(Long id);
    public Ticket modifySeat(String email, String section, String seatNumber);
}
