package cl.uchile.dcc.model.entities

import cl.uchile.dcc.model.items.{Weapon, Potion}

/**
 * Represents a playable character in the game.
 *
 * @param name The name of the character.
 * @param _hp The initial health points of the character.
 * @param _defense The initial defense points of the character.
 * @param weight The base weight of the character.
 */
abstract class Character(name: String, _hp: Int, private var _defense: Int, weight: Int) extends AbstractUnit(name, _hp, weight):
  private var _weaponSlot: Option[Weapon] = None
  private var _inventory: List[Potion] = List()

  def defense: Int = _defense
  def weaponSlot: Option[Weapon] = _weaponSlot
  def inventory: List[Potion] = _inventory

  override def actionBar: Double =
    var weaponWeight = 0
    if (weaponSlot.isDefined) {
      weaponWeight = weaponSlot.get.weight
    }
    weight + 0.5 * weaponWeight

  def equipWeapon(weapon: Weapon): Unit = {
    _weaponSlot = Some(weapon)
  }
