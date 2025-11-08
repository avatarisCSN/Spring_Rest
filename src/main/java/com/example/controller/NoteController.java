package com.example.controller;

import com.example.model.Note;
import com.example.repository.NoteRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/note")
public class NoteController {
    private final NoteRepository repo;

    public NoteController(NoteRepository repo) {
        this.repo = repo;
    }

    @GetMapping("/list")
    public ModelAndView getAllNotes() {
        ModelAndView result = new ModelAndView("note-list"); // note-list.html в templates/
        result.addObject("notes", repo.findAll()); // Передаём коллекцию заметок
        return result;
    }

    @PostMapping("/delete")
    public String deleteNote(@RequestParam long id) {
        repo.deleteById(id);
        return "redirect:/note/list"; // После удаления — редирект
    }

    @GetMapping("/edit")
    public ModelAndView editNoteForm(@RequestParam long id) {
        ModelAndView result = new ModelAndView("note-edit");
        Note note = repo.findById(id).orElse(new Note());
        result.addObject("note", note);
        return result;
    }

    @PostMapping("/edit")
    public String saveNote(@RequestParam long id,
                           @RequestParam String title,
                           @RequestParam String content) {
        repo.save(new Note( id, title, content));
        return "redirect:/note/list";
    }
    @GetMapping("/inject")
    public String injectNotes() {
        repo.injectTestNotes();
        return "redirect:/note/list"; // После добавления — редирект
    }
}