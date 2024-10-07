package com.cloudbees.app.cloudbeesApp.Service;

import com.cloudbees.app.cloudbeesApp.Respository.TicketRepository;
import com.cloudbees.app.cloudbeesApp.entity.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TickerServiceImpl implements TicketService{

    @Autowired
    private TicketRepository ticketRepository;

    @Override
    public Ticket purchaseTicket(Ticket ticket) {
        return ticketRepository.save(ticket);
    }
    @Override
    public Ticket getReceipt(String email) {
        return ticketRepository.findByEmail(email);
    }
    @Override
    public List<Ticket> getUsersBySection(String section) {
        return ticketRepository.findAllBySection(section);
    }
    @Override
    public void removeUser(Long id) {
        ticketRepository.deleteById(id);
    }
    @Override
    public Ticket modifySeat(String email, String section, String seatNumber) {
        Ticket ticket = ticketRepository.findByEmail(email);
        if (ticket != null) {
            ticket.setSection(section);
            ticket.setSeatNumber(seatNumber);
            return ticketRepository.save(ticket);
        }
        return null;
    }

}
