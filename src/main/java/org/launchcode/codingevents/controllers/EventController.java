package org.launchcode.codingevents.controllers;

import org.launchcode.codingevents.data.EventData;
import org.launchcode.codingevents.models.Event;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.AttributedString;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("events")
public class EventController {

//    private static List<Event> events = new ArrayList<>();

    @GetMapping
    public String displayAllEvents(Model model) {
//        List<String> events = new ArrayList<>();
//        events.add("Code With Pride");
//        events.add("Strange Loop");
//        events.add("Apple WWDC");
//        events.add("SpringOne Platform");
//        model.addAttribute("events", events);
        model.addAttribute("events", EventData.getAll());
        model.addAttribute("title", "All Events");
//        model.addAttribute("Title", title);
        return "events/index";
    }

    //lives at /event/create
    @GetMapping("create")
//    public String renderCreateEventForm(){
//        return "events/create";
    public String displayCreateEventForm(Model model) {
        model.addAttribute("title", "Create Event");
        model.addAttribute(new Event());
        return "events/create";
    }

    //    lives at /events/create
    @PostMapping("create")
//    public String processCreateEventForm(@RequestParam String eventName,
//                                         @RequestParam String eventDescription,
//                                         @RequestParam String eventAddress,
//                                         @RequestParam String eventDate){
//        EventData.add(new Event(eventName, eventDescription, eventAddress, eventDate));
    public String processCreateEventForm(@ModelAttribute @Valid Event newEvent, Errors errors, Model model) {
        if (errors.hasErrors()){
            model.addAttribute("title", "Create Event");
            return "events/create";
        }
        EventData.add(newEvent);
        return "redirect:";
    }

    @GetMapping("delete")
    public String displayDeleteEventForm(Model model) {
        model.addAttribute("title", "Delete Events");
        model.addAttribute("events", EventData.getAll());
        return "events/delete";
    }

    @PostMapping("delete")
    public String processDeleteEventForm(@RequestParam(required = false) int[] eventIds) {

        if (eventIds != null) {
            for (int id : eventIds) {
                EventData.remove(id);
            }
        }
        return "redirect";
    }

    @GetMapping("edit")
//    public String displayEditEventForm(Model model) {
//        model.addAttribute("events", EventData.getAll());
//        return "events/edit";
    public String displayEditEventForm(Model model) {
        model.addAttribute("title", "Edit Event");
        model.addAttribute("events", EventData.getAll());
        return "events/edit";
    }

    @PostMapping("edit")
    public String processEditEventForm(@RequestParam(required = false) int[] eventIds) {
//        public String processCreateEventForm(@ModelAttribute Event editEvent) {
//        EventData.add(newEvent);
        if (eventIds != null) {
            for (int id : eventIds) {
                EventData.edit(id);
            }
        }
        return "redirect:";
    }
}



