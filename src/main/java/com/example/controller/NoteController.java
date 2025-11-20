package com.example.controller;

import com.example.model.Note;
import com.example.repository.NoteRepository;
import com.example.service.NoteServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/note")
public class NoteController {
    private final NoteServiceImpl service;

    public NoteController(NoteServiceImpl service) {
        this.service = service;
    }

    @GetMapping("/list")
    public ModelAndView getAllNotes() {
        ModelAndView result = new ModelAndView("note-list"); // note-list.html в templates/
        result.addObject("notes", service.getAllNotes()); // Передаём коллекцию заметок
        return result;
    }

    @PostMapping("/delete")
    public RedirectView deleteNote(@RequestParam long id) {
        service.deleteById(id);
        return new RedirectView("/note/list");
    }

    @GetMapping("/edit")
    public ModelAndView editNoteForm(@RequestParam long id) {
        ModelAndView result = new ModelAndView("note-edit");
        Note note = service.getById(id);
        result.addObject("note", note);
        return result;
    }

    @PostMapping("/edit")
    public RedirectView saveNote(@RequestParam long id,
                           @RequestParam String title,
                           @RequestParam String content) {

       service.update(id, title, content);
        return new RedirectView("/note/list");
    }

    @GetMapping("/inject")
    public RedirectView injectNotes() {
        service.addTestNotes();
        return new RedirectView("/note/list");
    }
    @GetMapping("/public/hello")
    public String publicEndpoint() {
        return "Hello from the public endpoint!";
    }

    @GetMapping("/secure/hello")
    public String secureEndpoint(Principal principal) {
        String username = principal.getName();

        return "Hello from the secured endpoint, " + username + "!";
    }
}