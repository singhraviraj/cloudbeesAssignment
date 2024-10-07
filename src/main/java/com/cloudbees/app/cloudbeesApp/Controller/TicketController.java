package com.cloudbees.app.cloudbeesApp.Controller;

import com.cloudbees.app.cloudbeesApp.Service.TicketService;
import com.cloudbees.app.cloudbeesApp.entity.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tickets")
public class TicketController {

    @Autowired
    private TicketService ticketService;

    // Submit ticket purchase
    @PostMapping("/purchase")
    public Ticket purchaseTicket(@RequestBody Ticket ticket) {
        String section = ticketService.getUsersBySection("A").size() <= ticketService.getUsersBySection("B").size() ? "A" : "B";
        ticket.setSection(section);
        ticket.setSeatNumber("Seat-" + (ticketService.getUsersBySection(section).size() + 1));
        return ticketService.purchaseTicket(ticket);
    }

    // Get user receipt
    @GetMapping("/receipt/{email}")
    public Ticket getReceipt(@PathVariable String email) {
        return ticketService.getReceipt(email);
    }

    // Get users by section
    @GetMapping("/section/{section}")
    public List<Ticket> getUsersBySection(@PathVariable String section) {
        return ticketService.getUsersBySection(section);
    }

    // Remove user from train
    @DeleteMapping("/remove/{id}")
    public void removeUser(@PathVariable Long id) {
        ticketService.removeUser(id);
    }

    // Modify user seat
    @PutMapping("/modifySeat")
    public Ticket modifySeat(@RequestParam String email, @RequestParam String section, @RequestParam String seatNumber) {
        return ticketService.modifySeat(email, section, seatNumber);
    }

}
