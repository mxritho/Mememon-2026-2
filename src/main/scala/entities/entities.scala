package cl.uchile.dcc
package entities
import items.{Weapon, Potion}

trait Units:
  val name: String
  val weight: Int
  
  def defense: Int
  def hp: Int
  def actionBar: Double
  
abstract class Character(val name: String, private var _hp: Int, private var  _defense: Int, val weight: Int) extends Units:
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


abstract class MagicCharacter(name: String, hp: Int, defense: Int, weight: Int, private var _manaPoints: Int) extends
  Character(name, hp, defense, weight):
  def manaPoints: Int = _manaPoints

class Knight(name: String, hp: Int, defense: Int, weight: Int) extends Character(name, hp, defense, weight)
class Archer(name: String, hp: Int, defense: Int, weight: Int) extends Character(name, hp, defense, weight)
class Thief(name: String, hp: Int, defense: Int, weight: Int) extends Character(name, hp, defense, weight)
class BlackMage(name: String, hp: Int, defense: Int, weight: Int, manaPoints: Int) extends MagicCharacter(name, hp, defense, weight, manaPoints)
class WhiteMage(name: String, hp: Int, defense: Int, weight: Int, manaPoints: Int) extends MagicCharacter(name, hp, defense, weight, manaPoints)

class Enemy(val name: String, private var _hp: Int, val attack: Int, val defense: Int, val weight: Int) extends Units:
  def hp: Int = _hp
  override def actionBar: Double =
    weight.toDouble
class Player(private var _units: List[Units] = List()):
  def units: List[Units] = _units
  def isAlive: Boolean = _units.exists(_.hp > 0)

