package cl.uchile.dcc.model.entities

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
