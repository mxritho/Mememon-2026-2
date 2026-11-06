package cl.uchile.dcc.model.actions

trait Source:
  def executeAction(action: ActionTrait, target: Target): Unit
  def applyAttackTo(target: Target): Unit = {}
