package edu.grinnell.csc207.util;

import java.util.Arrays;

/**
 * A very simple implementation of dynamic arrays.
 *
 * @param <T>
 *   The type of value stored in the dynamic array.
 */
public class SimpleDynamicArray<T> implements DynamicArray<T> {
  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * All the known values in the array. values.length > the largest
   * i used in set.
   */
  T[] values;

  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Create a new expandable array.
   */
  @SuppressWarnings({"unchecked"})
  public SimpleDynamicArray() {
    this.values = (T[]) new Object[4];
  } // SimpleDynamicArray

  // +---------+-----------------------------------------------------
  // | Methods |
  // +---------+

  /**
   * Set the element i of the array to val.
   *
   * @param i
   *   The index into which we store the element.
   * @param val
   *   The value to store.
   *
   * @pre i >= 0
   * @post get(i) = val
   */
  public void set(int i, T val) {
    // If the array is not big enough, expand it
    if (this.values.length <= i) {
      // System.err.println("array expanded");
      int newsize = this.values.length * 2;
      while (newsize <= i) {
        newsize *= 2;
      } // while
      this.values = Arrays.copyOf(this.values, newsize);
    } // if the array is no big enough
    // And set the values
    this.values[i] = val;
  } // set(int, T)

  /**
   * Get element i of the array.
   *
   * @param i
   *   The index to retrieve.
   *
   * @return
   *   The most recent value stored using set(i, ...). If the ith
   *   element has not been set, returns null.
   *
   * @pre i >= 0
   */
  public T get(int i) {
    // If the array is not big enough, just return null
    if (this.values.length <= i) {
      return null;
    } // if the array is not big enough
    // Get the value
    return this.values[i];
  } // get(int)
} // class SimpleDynamicArray<T>
