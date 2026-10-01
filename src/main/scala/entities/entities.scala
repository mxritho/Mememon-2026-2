package entities
import items.{Weapon, Potion}

trait Units:
  val name: String
  var hp: Int
  var defense: Int
  var weight: Int
  def actionBar: Double

abstract class Character(val name: String, var hp: Int, var defense: Int, var weight: Int) extends Units:
  var weaponSlot: Option[Weapon] = None
  var inventory: List[Potion] = List()
  override def actionBar: Double =
    var weaponWeight = 0
    if (weaponSlot.isDefined) {
      weaponWeight = weaponSlot.get.weight
    }
    weight + 0.5 * weaponWeight


abstract class MagicCharacter(name: String, hp: Int, defense: Int, weight: Int, var manaPoints: Int) extends
  Character(name, hp, defense, weight)

class Knight(name: String, hp: Int, defense: Int, weight: Int) extends Character(name, hp, defense, weight)
class Archer(name: String, hp: Int, defense: Int, weight: Int) extends Character(name, hp, defense, weight)
class Thief(name: String, hp: Int, defense: Int, weight: Int) extends Character(name, hp, defense, weight)
class BlackMage(name: String, hp: Int, defense: Int, weight: Int, manaPoints: Int) extends MagicCharacter(name, hp, defense, weight, manaPoints)
class WhiteMage(name: String, hp: Int, defense: Int, weight: Int, manaPoints: Int) extends MagicCharacter(name, hp, defense, weight, manaPoints)

class Enemy(val name: String, var hp: Int, var attack: Int, var defense: Int, var weight: Int) extends Units:
  override def actionBar: Double =
    weight.toDouble
class Player(var units: List[Character] = List(), var isAlive: Boolean = true)

