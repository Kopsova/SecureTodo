package com.example.securetodo.Controllers;

import com.example.securetodo.Models.ToDo;
import com.example.securetodo.Repositories.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/todo")
public class TodoController {
    @Autowired
    TodoRepository repo;

    @GetMapping("/")
      public String index()  {
        return"index";
    }

    @GetMapping({"/list"})
    public String list(Model model, @RequestParam(value = "isActive", required = false) boolean active ) {
        List<ToDo> todos =(repo.findAll());
        if (active) {
            for (int i = 0; i < todos.size() ; i++) {
                if (todos.get(i).isDone()) {
                    todos.remove(i);
                }
            }
        }
        model.addAttribute("todos", todos);
        return "todolist";
    }

    @GetMapping(value = "/add")
    public String addForm(Model model) {
        model.addAttribute("todo", new ToDo());
        return "addtodo";
    }

    @PostMapping(value = "/add")
    public String addSubmit(@ModelAttribute ToDo todo) {
        repo.save(todo);
        return "redirect:/todo/list " ;
    }

    @RequestMapping(value = "/{id}/delete")
    public String deleteTodo (@PathVariable long id) {
        repo.deleteById(id);
        return "redirect:/todo/list" ;
    }

    @GetMapping(value="/{id}/edit")
    public String editForm (@PathVariable long id,Model model) {
        model.addAttribute("todo",repo.findById(id).get());
        return "edit" ;
    }

    @PostMapping(value="/{id}/edit")
    public String editSubmit (@ModelAttribute ToDo todo) {
        repo.save(todo) ;
        return "redirect:/todo/list ";
    }












}
