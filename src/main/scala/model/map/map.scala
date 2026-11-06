package cl.uchile.dcc.model.map
import cl.uchile.dcc.model.actions.{ActionTrait, Healing, Move, Purification, Source, Target}
import cl.uchile.dcc.model.entities.Units
import cl.uchile.dcc.model.exceptions.InvalidMovementException

/**
 * Represents a single grid tile (panel) on the game map where units can be positioned.
 *
 * @param x The horizontal coordinate of the panel.
 * @param y The vertical coordinate of the panel.
 */
class Panel(val x: Int, val y: Int) extends Target:
  private var _units: List[Units] = List()
  private var _adjacentPanels: List[Panel] = List()

  /** @return A list of all units currently located in this panel. */
  def units: List[Units] = _units

  /** @return A list of all panels directly adjacent to this one. */
  def adjacentPanels: List[Panel] = _adjacentPanels

  /** Adds a unit to this panel if it is not already present. */
  def addUnit(unit: Units): Unit =
    if (!_units.contains(unit)) _units = _units :+ unit

  /** Removes a unit from this panel. */
  def removeUnit(unit: Units): Unit =
    _units = _units.filterNot(_ == unit)

  /** Links another panel as adjacent to this one. */
  def addAdjacentPanel(panel: Panel): Unit =
    if (!_adjacentPanels.contains(panel)) _adjacentPanels = _adjacentPanels :+ panel

  override def receiveMove(action: Move, source: Source): Unit =
    if (!action.currentPanel.adjacentPanels.contains(this))
      throw new InvalidMovementException(s"Cannot move to panel ($x, $y) because it is not adjacent")
    source.executeMove(this, action.currentPanel)

  override def receiveHealing(action: Healing, source: Source): Unit = {
    throw new cl.uchile.dcc.model.exceptions.InvalidTargetException("A panel cannot receive Healing")
  }

  override def receivePurification(action: Purification, source: Source): Unit = {
    throw new cl.uchile.dcc.model.exceptions.InvalidTargetException("A panel cannot receive Purification")
  }

  override def receiveAction(action: ActionTrait, source: Source): Unit = {
    action.doAction(source, this)
  }

  override def receiveDamage(damage: Int): Unit = {
  }