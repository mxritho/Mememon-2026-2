package cl.uchile.dcc.model.entities
import cl.uchile.dcc.model.actions.{Source, Target, ActionTrait}

abstract class AbstractUnit(val name: String, protected var _hp: Int, val weight: Int) extends Units with Source with Target:
  def hp: Int = _hp

  def getAttackDamage: Int

  def receiveDamage(damage: Int): Unit = {
    val actualDamage = math.max(0, damage - defense)
    _hp -= actualDamage
    if (_hp < 0) _hp = 0
  }

  override def executeAction(action: ActionTrait, target: Target): Unit =
    action.doAction(this, target)

  override def receiveAttack(action: ActionTrait, source: Source): Unit =
    source.applyAttackTo(this)

  override def applyAttackTo(target: Target): Unit =
    target.receiveDamage(this.getAttackDamage)
    

