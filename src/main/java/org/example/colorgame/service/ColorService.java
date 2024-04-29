package org.example.colorgame.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import org.example.colorgame.model.Color;
import org.example.colorgame.repository.ColorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ColorService {

  @Autowired
  private ColorRepository colorRepository;

  // Attributes
  // private List<String> colors = Arrays.asList("Red", "Blue", "Green", "Yellow", "Orange", "Purple");
  private Random random = new Random();
  private  Color currentColor;


  public List<Color> getColors() {
    return colorRepository.findAll();
  }

  public List<String> getColorNames() {
    List<String> colorNames = new ArrayList<>();
    for (Color color: getColors()) {
      colorNames.add(color.getName());
    }
    return colorNames;
  }

  public Color getCurrentColor() {
    return currentColor;
  }

  /**
   * Randomly selects a color from the list
   * @return  the selected color
   * */
  public Color getRandomColor(){
    // colors list
    List<Color> colors = getColors();
    currentColor = colors.get(random.nextInt(colors.size()));
    System.out.println(currentColor);
    return currentColor;
  }

  /**
   * Validates the user's guess against the selected color
   * @return  true if the guess is correct, otherwise false
   * */
  public boolean validateGuess(String guess){
    return guess!=null && guess.equalsIgnoreCase(currentColor.getName());
  }

}
