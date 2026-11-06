package cl.uchile.dcc.model.actions

trait Target:
  def receiveAction(action: ActionTrait, source: Source): Unit
  def receiveDamage(damage: Int): Unit
  def receiveAttack(action: Attack, source: Source): Unit = {}