package com.virrantech.utills;

import java.util.Random;

public class RandomNumStringGenerator {

  
  public static int getRandomNumer(){
    Random rand = new Random();
    int maximum=8,minimum=7;
    return  minimum + rand.nextInt((maximum - minimum) + 1);
  }
}
