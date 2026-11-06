package cl.uchile.dcc.model.items
import cl.uchile.dcc.model.entities.Character
/** Represents a Bow, a ranged physical weapon. */
class Bow(name: String, attackPoints: Int, weight: Int, owner: Character) extends Weapon(name, attackPoints, weight, owner):
  override def isBow: Boolean = true