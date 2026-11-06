package cl.uchile.dcc.model.entities

/**
 * Represents a player that controls a group of units.
 *
 * @param _units The list of units controlled by the player.
 */
class Player(private var _units: List[Units] = List()):
  /** @return The list of units owned by the player. */
  def units: List[Units] = _units

  /**
   * Checks if the player is still alive in the game.
   * A player is considered alive if at least one of their units has health points greater than zero.
   *
   * @return True if the player is alive, false if defeated.
   */
  def isAlive: Boolean = _units.exists(_.hp > 0)