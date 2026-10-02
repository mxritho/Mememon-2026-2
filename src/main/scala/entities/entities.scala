package cl.uchile.dcc
package entities
import items.{Weapon, Potion}

/**
 * Base trait for all combat units in the game.
 * Defines the common attributes and methods required for the turn system.
 */
trait Units:
  /** The name of the unit. */
  val name: String
  /** The base weight of the unit, used to calculate turn speed. */
  val weight: Int

  /** @return The defense points of the unit. */
  def defense: Int

  /** @return The current health points (HP) of the unit. */
  def hp: Int

  /**
   * Calculates the maximum action bar capacity for this unit's turn.
   *
   * @return The maximum action bar value as a Double.
   */
  def actionBar: Double

/**
 * Represents a playable character in the game.
 *
 * @param name The name of the character.
 * @param _hp The initial health points of the character.
 * @param _defense The initial defense points of the character.
 * @param weight The base weight of the character.
 */
abstract class Character(val name: String, private var _hp: Int, private var _defense: Int, val weight: Int) extends Units:
  private var _weaponSlot: Option[Weapon] = None
  private var _inventory: List[Potion] = List()

  def hp: Int = _hp
  def defense: Int = _defense
  def weaponSlot: Option[Weapon] = _weaponSlot
  def inventory: List[Potion] = _inventory

  override def actionBar: Double =
    var weaponWeight = 0
    if (weaponSlot.isDefined) {
      weaponWeight = weaponSlot.get.weight
    }
    weight + 0.5 * weaponWeight

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

/** Represents a Knight character. */
class Knight(name: String, hp: Int, defense: Int, weight: Int) extends Character(name, hp, defense, weight)

/** Represents an Archer character. */
class Archer(name: String, hp: Int, defense: Int, weight: Int) extends Character(name, hp, defense, weight)

/** Represents a Thief character. */
class Thief(name: String, hp: Int, defense: Int, weight: Int) extends Character(name, hp, defense, weight)

/** Represents a Black Mage character capable of casting dark magic. */
class BlackMage(name: String, hp: Int, defense: Int, weight: Int, manaPoints: Int) extends MagicCharacter(name, hp, defense, weight, manaPoints)

/** Represents a White Mage character capable of casting light magic. */
class WhiteMage(name: String, hp: Int, defense: Int, weight: Int, manaPoints: Int) extends MagicCharacter(name, hp, defense, weight, manaPoints)

/**
 * Represents an enemy unit in the game.
 *
 * @param name The name of the enemy.
 * @param _hp The initial health points of the enemy.
 * @param attack The attack power of the enemy.
 * @param defense The defense points of the enemy.
 * @param weight The weight of the enemy, used to calculate its action bar.
 */
class Enemy(val name: String, private var _hp: Int, val attack: Int, val defense: Int, val weight: Int) extends Units:
  def hp: Int = _hp

  /**
   * Calculates the maximum action bar capacity for the enemy.
   * For enemies, it is strictly equal to their base weight.
   *
   * @return The action bar value as a Double.
   */
  override def actionBar: Double =
    weight.toDouble

/**
 * Represents a player that controls a group of units.
 *
 * @param _units The list of units controlled by the player.
 */
class Player(private var _units: List[Units] = List()):
  /** @return The list of units owned by the player. */
  def units: List[Units] = _units

  /**
   * Checks if the player is still alive in the game.
   * A player is considered alive if at least one of their units has health points greater than zero.
   *
   * @return True if the player is alive, false if defeated.
   */
  def isAlive: Boolean = _units.exists(_.hp > 0)