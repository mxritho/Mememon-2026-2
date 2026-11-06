package cl.uchile.dcc.model.entities
import cl.uchile.dcc.model.actions.{ActionTrait, Attack, Meteor, Source, Target, Thunder}
import cl.uchile.dcc.model.exceptions.{InvalidTargetException, RequerimentNotMeetException}
import cl.uchile.dcc.model.map.Panel

abstract class AbstractUnit(val name: String, protected var _hp: Int, val weight: Int) extends Units with Source with Target:
  def hp: Int = _hp

  def getAttackDamage: Int

  def receiveDamage(damage: Int): Unit = {
    val actualDamage = math.max(0, damage - defense)
    _hp -= actualDamage
    if (_hp < 0) _hp = 0
  }

  override def executeAction(action: ActionTrait, target: Target): Unit = {
    if (this.hp <= 0) then
      throw new RequerimentNotMeetException(s"The unit $name is defeated and cannot perform actions")
    action.doAction(this, target)
  }

  override def receiveAttack(action: Attack, source: Source): Unit = {
    if (this.hp <= 0) then
      throw new InvalidTargetException(s"The unit $name is already defeated and cannot be attacked")
    source.applyAttackTo(this)
  }

  override def applyAttackTo(target: Target): Unit =
    target.receiveDamage(this.getAttackDamage)

  override def checkAttackRequeriments(): Unit = {}

  override def checkMagicRequeriments(manaCost: Int): Unit =
    throw new RequerimentNotMeetException(s"$name cannot cast spells")

  override def executeMove(targetPanel: Panel, currentPanel: Panel): Unit =
    currentPanel.removeUnit(this)
    targetPanel.addUnit(this)

  override def receiveThunder(action: Thunder, source: Source): Unit =
    if (this.hp <= 0) throw new InvalidTargetException(s"The unit $name is defeated and cannot receive Thunder")

  override def receiveMeteor(action: Meteor, source: Source): Unit =
    if (this.hp <= 0) throw new InvalidTargetException(s"The unit $name is defeated and cannot receive Meteor")

