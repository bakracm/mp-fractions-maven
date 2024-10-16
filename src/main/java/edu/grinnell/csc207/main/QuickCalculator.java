package edu.grinnell.csc207.main;

import java.io.PrintWriter;
import edu.grinnell.csc207.util.BigFraction;

/**
 * Calculate expressions from the command line.
 *
 * @author Mina Bakrac
 */
public class QuickCalculator {
  /**
   * Evaluates and prints the expression based on comand line arguments.
   *
   * @param args
   *   command line arguments.
   */
  public static void main(String[] args) throws Exception {
    PrintWriter pen = new PrintWriter(System.out, true);
    BigFraction eval = new BigFraction(args[0]);
    for (int i = 1; i < args.length; i++) {
      if (args[i] == "+") {
        eval = eval.add(new BigFraction(args[i + 1]));
      } // if
      if (args[i] == "-") {
        eval = eval.subtract(new BigFraction(args[i + 1]));
      } // if
      if (args[i] == "*") {
        eval = eval.multiply(new BigFraction(args[i + 1]));
      } // if
      if (args[i] == "/") {
        eval = eval.divide(new BigFraction(args[i + 1]));
      } // if
    } // for
    pen.println(eval);
    pen.close();
  } // main(String[])

    // public static BigFraction argToBf(String str) {
    //     int resultNumerator;
    //     int resultDenomerator;
    //     int charDivSign = 0;
    //     for (int i = 0; i < str.length(); i++) {
    //         if (i == '/') {
    //             charDivSign = i;
    //         } // if
    //     } // for
    //     resultNumerator = Integer.valueOf(str.substring(0,charDivSign));
    //     resultDenomerator = Integer.valueOf(str.substring(1 + charDivSign, str.length()));
    //     return new BigFraction(resultNumerator, resultDenomerator);
    // } // argToBf
} // class QuickCalculator
