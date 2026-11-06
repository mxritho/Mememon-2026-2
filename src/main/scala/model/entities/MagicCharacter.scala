package cl.uchile.dcc.model.entities

import cl.uchile.dcc.model.exceptions.RequerimentNotMeetException

/**
 * Represents a playable magic character that can cast spells using mana.
 *
 * @param name The name of the magic character.
 * @param hp The initial health points.
 * @param defense The initial defense points.
 * @param weight The base weight of the character.
 * @param _manaPoints The initial mana points used for spells.
 */
abstract class MagicCharacter(name: String, hp: Int, defense: Int, weight: Int, private var _manaPoints: Int) extends
  Character(name, hp, defense, weight):

  /** @return The current mana points of the magic character. */
  def manaPoints: Int = _manaPoints

  override def checkMagicRequeriments(manaCost: Int): Unit = {
    if (manaPoints < manaCost)
      throw new RequerimentNotMeetException(s"$name does not have enough mana to cast spells")
    if (weaponSlot.isEmpty || !weaponSlot.get.isMagical)
      throw new RequerimentNotMeetException(s"$name needs to equip a magic weapon to cast spells")
  }
