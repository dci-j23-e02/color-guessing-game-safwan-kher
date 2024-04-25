package org.example.colorgame.service;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import org.springframework.stereotype.Service;

@Service
public class ColorService {

  // Attributes
  private List<String> colors = Arrays.asList("Red", "Blue", "Green", "Yellow", "Orange", "Purple");
  private Random random = new Random();
  private  String currentColor;


  public List<String> getColors() {
    return colors;
  }

  public String getCurrentColor() {
    return currentColor;
  }

  /**
   * Randomly selects a color from the list
   * @return  the selected color
   * */
  public String getRandomColor(){
    currentColor = colors.get(random.nextInt(colors.size()));
    System.out.println(currentColor);
    return currentColor;
  }

  /**
   * Validates the user's guess against the selected color
   * @return  true if the guess is correct, otherwise false
   * */
  public boolean validateGuess(String guess){
    return guess!=null && guess.equalsIgnoreCase(currentColor);
  }

}
