package cl.uchile.dcc.model.actions
import cl.uchile.dcc.model.map.Panel

/** Action that allows a unit to move to an adjacent panel on the map. */
class Move(val currentPanel: Panel) extends Action("Move"):
  override def doAction(source: Source, target: Target): Unit =
    target.receiveMove(this, source)