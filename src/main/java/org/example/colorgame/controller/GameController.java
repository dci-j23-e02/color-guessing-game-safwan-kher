package org.example.colorgame.controller;


import org.example.colorgame.service.ColorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;


@Controller
public class GameController {

  // Field injection
  @Autowired
  private ColorService colorService;




  }
