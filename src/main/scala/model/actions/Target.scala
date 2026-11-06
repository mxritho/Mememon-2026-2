package cl.uchile.dcc.model.actions

/**
 * Interface that defines a target capable of receiving actions in the game.
 */
trait Target:
  def receiveAction(action: ActionTrait, source: Source): Unit
  def receiveDamage(damage: Int): Unit

  def receiveAttack(action: Attack, source: Source): Unit = {}
  def receiveMove(action: Move, source: Source): Unit = {}
  def receiveEquipWeapon(action: EquipWeapon, source: Source): Unit = {}
  def receiveConsumePotion(action: ConsumePotion, source: Source): Unit = {}
  def receiveThunder(action: Thunder, source: Source): Unit = {}
  def receiveMeteor(action: Meteor, source: Source): Unit = {}
  def receiveHealing(action: Healing, source: Source): Unit = {}
  def receivePurification(action: Purification, source: Source): Unit = {}