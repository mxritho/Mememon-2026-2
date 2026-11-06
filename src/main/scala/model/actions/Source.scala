package cl.uchile.dcc.model.actions
import cl.uchile.dcc.model.map.Panel
trait Source:
  def executeAction(action: ActionTrait, target: Target): Unit
  def applyAttackTo(target: Target): Unit
  def checkAttackRequeriments(): Unit
  def checkMagicRequeriments(manaCost: Int): Unit
  def executeMove(targetPanel: Panel, currentPanel: Panel): Unit