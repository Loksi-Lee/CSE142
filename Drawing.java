// A short introduction program to DrawingPanel

import java.awt.*;

public class Drawing {
   public static void main(String[] args) {
      // chapter 3G -- graphics
      // procedural programming -- action, command
      // static method
      // object oriented language
      // object laters
      // practice with use objects
      // primitive types: int, double, char, boolean
      // object types: defined by a class: String, String.java
      // custom class: DrawingPanel
      int x = 3;
      String s = "word";
      DrawingPanel panel = new DrawingPanel(400, 200);
      
      // objects converse with each other
      
      // "where to talk" reference. "phone number"
      // "how to talk to it" dot notation
      
      panel.setBackground(Color.CYAN);
      
      Graphics g = panel.getGraphics(); // paintbrush
      g.drawLine(10, 10, 50, 50);
      
      g.setColor(Color.RED);
      g.fillRect(70, 70, 20, 20);
      
      
      g.fillOval(150, 150, 30, 30);
      
   }
} 