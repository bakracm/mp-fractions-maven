package edu.grinnell.csc207.main;
import java.util.Scanner;

import edu.grinnell.csc207.util.BFCalculator;
import edu.grinnell.csc207.util.BFRegisterSet;


/**
 * Contains the main implementation of Interactive Calculator;
 * Takes in user input.
 *
 * @author Mina Bakrac
 */
public class InteractiveCalculator {

  /**
   * Repeatedly read a line the user types, compute the result, and print the result for the user.
   *
   * @param args
   *   Command-line arguments; ignored.
   *
   * @throws Exception
   *   When we have some unexpected I/O issue.
   */
  public static void main(String[] args) throws Exception {
    java.io.PrintWriter pen;
    pen = new java.io.PrintWriter(System.out, true);
    BFRegisterSet reg = new BFRegisterSet();
    BFCalculator calc = new BFCalculator();
    Scanner scan = new Scanner(System.in);
    String line = scan.nextLine();
    // infinite loop while input is being given by user
    while (true) {
      if (line.substring(0, 5).equals("STORE")) {
        reg.store((line.substring(6, 7)).charAt(0), calc.get());
      } else if (line.equals("QUIT")) {
        break;
      } else {
        for (int i = 0; i < line.length(); i++) {
          if (line.charAt(i) == '+') {
            // evaluate the expression
            pen.println(calc.get());
          } // if
          if (line.charAt(i) == '-') {
            // evaluate the expression
            pen.println(calc.get());
          } // if
          if (line.charAt(i) == '*') {
            // evaluate the expression
            pen.println(calc.get());
          } // if
          //if (line.charAt(i) == ' / '){}
        } // for
      } // if/else
    } // while
    pen.close();
    scan.close();
  } // main(String[])
} // class InteractiveCalculator
