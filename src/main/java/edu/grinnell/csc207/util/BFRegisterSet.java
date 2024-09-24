package edu.grinnell.csc207.util;

/**
 * Set of registers that store BigFractions; Methods to store and access fractions and registers.
 *
 * @author Mina Bakrac
 */
public class BFRegisterSet {

  // +-----------+---------------------------------------------------
  // | Constants |
  // +-----------+

  // Create an array to store 26 fractions (each corresponding to a letter in the alphabet)
  BigFraction[] Register = new BigFraction[26];
  
  // The base value corresponding to "a" in ASCII
  int baseVal = 97;

  // +---------+------------------------------------------------------
  // | Methods |
  // +---------+

  /**
   * Divide a fraction with this fraction
   *
   * @param register
   *   The register in which to store
   * @param val
   *   The value to be stored
   */
  public void store(char register, BigFraction val){
    // Find the ASCII value of the register
    int i = Integer.valueOf(register);

    // If the register is between a-z, store in the appropriate index
    if ((i < 123) && (i > 96)){
        Register[i - baseVal] = val;
    }
  } // store(char, BigFraction)
  
  /**
   * Access the value (fraction) located in a register
   *
   * @param register
   *   The register to access
   *
   * @return the fraction in the register
   */
  public BigFraction get(char register){
    // Find the ASCII value of the register
    int i = Integer.valueOf(register);

    // return the value at the appropriate index
    return Register[i - baseVal];
  } // get(char)
} // class BFRegisterSet
