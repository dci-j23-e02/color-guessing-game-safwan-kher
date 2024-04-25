package org.example.colorgame.controller;


import org.example.colorgame.service.ColorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class GameController {

  // Field injection
  @Autowired
  private ColorService colorService;

@GetMapping("/")
  public String startGame(Model model){
  String color = colorService.getRandomColor();
  model.addAttribute("currentColor", color);
  model.addAttribute("colors", colorService.getColors());
  return  "index";
}

@GetMapping("/guess")
  public String guess(@RequestParam String guess,Model model){
  boolean isCorrect = colorService.validateGuess(guess);
  model.addAttribute("message",
      isCorrect ? "Correct! The color was"+ colorService.getCurrentColor() : "Incorrect! Try again.");

  return  "result";


}


  }
