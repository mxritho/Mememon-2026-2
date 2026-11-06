package cl.uchile.dcc.model.entities

/**
 * Represents a player that controls a group of units.
 */
class Player(private var _units: List[Units] = List()):
  /** @return The list of units owned by the player. */
  def units: List[Units] = _units

  /** @return True if the player has at least one unit alive, false if defeated. */
  def isAlive: Boolean = _units.exists(_.hp > 0)