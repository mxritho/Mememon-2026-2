package cl.uchile.dcc
package model.actions

/** Action that allows a unit to move to an adjacent panel on the map. */
class Move extends Action("Move"):
  override def doAction(source: Source, target: Target): Unit =
    target.receiveMove(this, source)