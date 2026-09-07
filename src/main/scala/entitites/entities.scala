package cl.uchile.dcc
package entitites

// Traits
trait Character:
  val name: String
  var hp: Int
  var defense: Int
  var weight: Int
  var weaponSlot: Option[Weapon] = None
  var inventory: List[Any] = List()

trait MagicCharacter extends Character:
  var manaPoints: Int

trait Weapon:
  val name: String
  val attackPoints: Int
  val weight: Int
  val owner: Character

trait MagicWeapon extends Weapon:
  val manaPower: Int

trait Potion:
  val name: String

// Clases de Unidades
class Knight(val name: String, var hp: Int, var defense: Int, var weight: Int) extends Character
class Archer(val name: String, var hp: Int, var defense: Int, var weight: Int) extends Character
class Thief(val name: String, var hp: Int, var defense: Int, var weight: Int) extends Character
class BlackMage(val name: String, var hp: Int, var defense: Int, var weight: Int, var manaPoints: Int) extends MagicCharacter
class WhiteMage(val name: String, var hp: Int, var defense: Int, var weight: Int, var manaPoints: Int) extends MagicCharacter

class Enemy(val name: String, var hp: Int, var attack: Int, var defense: Int, var weight: Int)
class Player(var units: List[Character] = List(), var isAlive: Boolean = true)

