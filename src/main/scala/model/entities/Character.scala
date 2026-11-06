package cl.uchile.dcc.model.entities

import cl.uchile.dcc.model.actions.{ActionTrait, EquipWeapon, Source, Healing, Purification}
import cl.uchile.dcc.model.items.{Potion, Weapon}
import cl.uchile.dcc.model.exceptions.{InvalidTargetException, RequerimentNotMeetException}

/**
 * Represents a playable character in the game.
 */
abstract class Character(name: String, _hp: Int, private var _defense: Int, weight: Int) extends AbstractUnit(name, _hp, weight):
  private var _weaponSlot: Option[Weapon] = None
  private var _inventory: List[Potion] = List()

  /** @return The current defense points. */
  def defense: Int = _defense
  /** @return The weapon currently equipped by the character. */
  def weaponSlot: Option[Weapon] = _weaponSlot
  /** @return The inventory of potions held by the character. */
  def inventory: List[Potion] = _inventory

  def receiveAction(action: ActionTrait, source: Source): Unit =
    action.doAction(source, this)

  /** Validates if the character can equip the specified weapon. */
  def checkEquipRequeriments(weapon: Weapon): Unit

  override def actionBar: Double =
    var weaponWeight = 0
    if (weaponSlot.isDefined) {
      weaponWeight = weaponSlot.get.weight
    }
    weight + 0.5 * weaponWeight

  /** Equips a weapon to the character's weapon slot. */
  def equipWeapon(weapon: Weapon): Unit = {
    _weaponSlot = Some(weapon)
  }

  override def getAttackDamage: Int =
    if (weaponSlot.isDefined) weaponSlot.get.attackPoints else 0

  override def checkAttackRequeriments(): Unit =
    if (weaponSlot.isEmpty) then throw new RequerimentNotMeetException(s"$name cannot attack without an equipped weapon")

  override def receivePurification(action: Purification, source: Source): Unit = {
    if (this.hp <= 0)
      throw new InvalidTargetException(s"$name is defeated and cannot receive actions")
    throw new InvalidTargetException(s"$name is a character and cannot receive Purification")
  }

  override def receiveHealing(action: Healing, source: Source): Unit =
    if (this.hp <= 0) throw new InvalidTargetException(s"$name is defeated and cannot receive Healing")

  override def receiveEquipWeapon(action: EquipWeapon, source: Source): Unit =
    if (this.hp <= 0) throw new InvalidTargetException(s"$name is defeated and cannot equip weapons")
    this.checkEquipRequeriments(action.weaponToEquip)
    this.equipWeapon(action.weaponToEquip)