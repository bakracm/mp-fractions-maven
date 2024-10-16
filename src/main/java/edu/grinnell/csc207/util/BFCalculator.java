package edu.grinnell.csc207.util;

/**
 * Provides the key BigFraction methods for last computed value.
 *
 * @author Mina Bakrac
 */
public class BFCalculator {

  // +--------+-------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * Sets the default value as 0.
   */
  BigFraction lastVal = new BigFraction(0, 1);

  // +---------+------------------------------------------------------
  // | Methods |
  // +---------+

  /**
   * Gets the last computed value.
   *
   * @return last computed value.
   */
  public BigFraction get() {
    return lastVal;
  } // get()

  /**
   * Adds val (fraction) to the last computed value.
   *
   * @param val
   *   The value to add.
   */
  public void add(BigFraction val) {
    lastVal = lastVal.add(val);
  } // add(BigFraction)

  /**
   * Subtracts val (fraction) from the last computed value.
   *
   * @param val
   *   The value to subtract
   */
  public void subtract(BigFraction val) {
    lastVal = lastVal.subtract(val);
  } // subtract(BigFraction)

  /**
   * Multiplies the last computed value by val (fraction).
   *
   * @param val
   *   The value to multiply by
   */
  public void multiply(BigFraction val) {
    lastVal = lastVal.multiply(val);
  } // multiply(BigFraction)

  /**
   * Divides the last computed value by val (fraction).
   *
   * @param val
   *   The value to divide with
   */
  public void divide(BigFraction val) {
    lastVal = lastVal.divide(val);
  } // divide(BigFraction)

  /**
   * Resets the last computed value to 0.
   */
  public void clear() {
    lastVal = new BigFraction(0, 1);
  } // clear()
} // class BFCalculator
