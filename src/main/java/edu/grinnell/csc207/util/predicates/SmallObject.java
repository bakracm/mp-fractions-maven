package edu.grinnell.csc207.util.predicates;

import edu.grinnell.csc207.util.Predicate;

/**
 * Predicates for objects.  Uses a form of the Singleton pattern.
 * Clients cannot create SmallObject objects; they must reference
 * SmallObject.PRED.
 *
 * @author Samuel A. Rebelsky
 * @author Mina Bakrac
 * @author Anthony Castleberry
 */
public class SmallObject implements Predicate<Object> {
  // +-----------+---------------------------------------------------
  // | Constants |
  // +-----------+

  /**
   * One copy of this predicate, following the singleton pattern.
   */
  public static final SmallObject PRED = new SmallObject();

  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Create a new predicate. Made private to prevent clients from
   * creating new objects (part of the singleton pattern).
   */
  private SmallObject() {
  } // SmallObject()

  // +---------+-----------------------------------------------------
  // | Methods |
  // +---------+

  /**
   * Determine if val is a small object.
   *
   * @param val
   *   The object we evaluate.
   *
   * @return
   *   true if val is small and false otherwise.
   */
  public boolean holds(Object val) {
    String str = String.valueOf(val);
    return str.length() < 5;
  } // holds(object)
} // class SmallObject
