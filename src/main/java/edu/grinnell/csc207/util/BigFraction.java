package edu.grinnell.csc207.util;
import java.math.BigInteger;

/**
 * Implementation of fractions using the BigInteger type
 *
 * @author Mina Bakrac
 * @author Sam Rebelsky
 */
public class BigFraction {

  // +--------+-------------------------------------------------------
  // | Fields |
  // +--------+

  /** The numerator of the fraction. Can be positive, zero or negative. */
  BigInteger num;

  /** The denominator of the fraction. Must be non-negative. */
  BigInteger denom;

  // +--------------+-------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Build a new fraction with numerator num and denominator denom.
   *
   * @param numerator
   *   The numerator of the fraction.
   * @param denominator
   *   The denominator of the fraction.
   */
  public BigFraction(BigInteger numerator, BigInteger denominator) {
    this.num = numerator;
    this.denom = denominator;
  } // BigFraction(BigInteger, BigInteger)

  public BigFraction(String str){
    this.num = BigInteger.valueOf(Long.valueOf(str.split("/")[0]));
    this.denom = BigInteger.valueOf(Long.valueOf(str.split("/")[1]));
  }

  /**
   * Build a new fraction with numerator num and denominator denom **INTEGER**.
   *
   * @param numerator
   *   The numerator of the fraction.
   * @param denominator
   *   The denominator of the fraction.
   */
  public BigFraction(int numerator, int denominator) {
    this.num = BigInteger.valueOf(numerator);
    this.denom = BigInteger.valueOf(denominator);
  } // BigFraction(int, int)

  // +---------+------------------------------------------------------
  // | Methods |
  // +---------+

  /**
   * Express this fraction as a double.
   *
   * @return the fraction approxiamted as a double.
   */
  public double doubleValue() {
    return this.num.doubleValue() / this.denom.doubleValue();
  } // doubleValue()

  /**
   * Add another faction to this fraction.
   *
   * @param addend
   *   The fraction to add.
   *
   * @return the result of the addition.
   */
  public BigFraction add(BigFraction addend) {
    BigInteger resultNumerator;
    BigInteger resultDenominator;

    // The denominator of the result is the product of this object's
    // denominator and addend's denominator
    resultDenominator = this.denom.multiply(addend.denom);
    // The numerator is more complicated
    resultNumerator =
      (this.num.multiply(addend.denom)).add(addend.num.multiply(this.denom));

    // Return the computed value
    return new BigFraction(resultNumerator, resultDenominator);
  } // add(BigFraction)

  /**
   * Subtract another faction from this fraction.
   *
   * @param tosub
   *   The fraction to subtract.
   *
   * @return the result of the subtraction.
   */
  public BigFraction subtract(BigFraction tosub) {
    BigInteger resultNumerator;
    BigInteger resultDenominator;

    // The denominator of the result is the product of this object's
    // denominator and tosub's's denominator
    resultDenominator = this.denom.multiply(tosub.denom);
    // The numerator is more complicated
    resultNumerator =
      (this.num.multiply(tosub.denom)).subtract(tosub.num.multiply(this.denom));

    // Return the computed value
    return new BigFraction(resultNumerator, resultDenominator);
  } // subtract(BigFraction)

  /**
   * Multiply a fraction with this fraction
   *
   * @param multfrac
   *   The fraction to multiply.
   *
   * @return the result of the multiplication.
   */
  public BigFraction multiply(BigFraction multfrac) {
    BigInteger resultNumerator;
    BigInteger resultDenominator;

    // We get the resulting numerators and denominators by multiplying num1 by num2 and denom1 by denom2
    resultDenominator = this.denom.multiply(multfrac.denom);
    resultNumerator = this.num.multiply(multfrac.num);
  
    // Return the computed value
    return new BigFraction(resultNumerator, resultDenominator);
  } // multiply(BigFraction)

  /**
   * Divide a fraction with this fraction
   *
   * @param todiv
   *   The fraction to divide.
   *
   * @return the result of the division.
   */
  public BigFraction divide(BigFraction todiv) {
    BigInteger resultNumerator;
    BigInteger resultDenominator;

    // We get the resulting numerators and denominators by multiplying num1 by denom2 and num2 by denom1
    resultDenominator = this.denom.multiply(todiv.num);
    resultNumerator = this.num.multiply(todiv.denom);
  
    // Return the computed value
    return new BigFraction(resultNumerator, resultDenominator);
  } // divide(BigFraction)

  /**
   * Get the denominator of this fraction.
   *
   * @return the denominator
   */
  public BigInteger denominator() {
    return this.denom;
  } // denominator()

  /**
   * Get the numerator of this fraction.
   *
   * @return the numerator
   */
  public BigInteger numerator() {
    return this.num;
  } // numerator()

  /**
   * Simplify the fraction by dividing the numerator and denominator by greatest common divisor
   *
   * @return the simplified fraction
   */
  public BigFraction simpleFraction(){
    BigInteger resultNumerator = this.num;
    BigInteger resultDenominator = this.denom;

    if (this.num.intValue() > this.denom.intValue()){
      for(int i = this.num.intValue(); i > 0; i--){
        if ((this.num.intValue() % i == 0) && (this.denom.intValue() % i == 0)){
          resultNumerator = resultNumerator.divide(BigInteger.valueOf(i));
          resultDenominator = resultDenominator.divide(BigInteger.valueOf(i));
        }
      }
    }
    else if (this.num.intValue() < this.denom.intValue()){
      for(int i = this.denom.intValue(); i > 0; i--){
        if ((this.num.intValue() % i == 0) && (this.denom.intValue() % i == 0)){
          resultNumerator = resultNumerator.divide(BigInteger.valueOf(i));
          resultDenominator = resultDenominator.divide(BigInteger.valueOf(i));
        }
      }
    }
    else{
      resultNumerator = BigInteger.valueOf(1);
      resultDenominator = BigInteger.valueOf(1);
    }

    return new BigFraction(resultNumerator, resultDenominator);
  } // simpleFraction()

   /**
   * Convert this fraction to a string for ease of printing.
   *
   * @return a string that represents the fraction.
   */
  public String toString() {
    // Special case: It's zero
    if (this.num.equals(BigInteger.ZERO)) {
      return "0";
    } // if it's zero

    // Lump together the string represention of the numerator,
    // a slash, and the string representation of the denominator
    // return this.num.toString().concat("/").concat(this.denom.toString());
    return this.num + "/" + this.denom;
  } // toString()
} // class BigFraction
