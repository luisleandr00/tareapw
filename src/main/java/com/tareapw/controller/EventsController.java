package com.tareapw.controller;

import com.tareapw.entity.EventsEntity;
import com.tareapw.service.EventsServiceImp;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("events")
public class EventsController {
    private final EventsServiceImp eventsServiceImp;

    @GetMapping
    public String events(Model model) {
        model.addAttribute("events", eventsServiceImp.getAll());
        return "events";
    }

    @GetMapping("create")
    public String createForm(Model model) {
        model.addAttribute("event", new EventsEntity());
        return "create_event";
    }

    @PostMapping("create")
    public String save(@ModelAttribute EventsEntity event) {
        eventsServiceImp.create(event);
        return "redirect:/events";
    }

    @GetMapping("edit/{id}")
    public String editForm(@PathVariable Long id, Model model) {
        EventsEntity event = eventsServiceImp.getById(id);
        model.addAttribute("event", event);
        return "edit_event";
    }

    @PostMapping("edit/{id}")
    public String update(@PathVariable Long id, @ModelAttribute EventsEntity event) {
        eventsServiceImp.update(id, event);
        return "redirect:/events";
    }

    @PostMapping("delete/{id}")
    public String delete(@PathVariable Long id) {
        eventsServiceImp.delete(id);
        return "redirect:/events";
    }
}