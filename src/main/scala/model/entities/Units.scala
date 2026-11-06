package cl.uchile.dcc.model.entities

/**
 * Base trait for all combat units in the game.
 * Defines the common attributes and methods required for the turn system.
 */
trait Units:
  /** The name of the unit. */
  val name: String
  /** The base weight of the unit, used to calculate turn speed. */
  val weight: Int

  /** @return The defense points of the unit. */
  def defense: Int

  /** @return The current health points (HP) of the unit. */
  def hp: Int

  /**
   * Calculates the maximum action bar capacity for this unit's turn.
   *
   * @return The maximum action bar value as a Double.
   */
  def actionBar: Double
