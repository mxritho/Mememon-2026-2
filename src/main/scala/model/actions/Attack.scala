package cl.uchile.dcc
package model.actions

/** Action that allows a unit to physically attack an enemy target. */
class Attack extends Action("Attack"):
  override def doAction(source: Source, target: Target): Unit = {
    source.checkAttackRequeriments()
    target.receiveAttack(this, source)
  }
