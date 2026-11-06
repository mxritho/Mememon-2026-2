package cl.uchile.dcc.model.items
import cl.uchile.dcc.model.entities.Character
/** Represents a Sword, a common physical weapon. */
class Sword(name: String, attackPoints: Int, weight: Int, owner: Character) extends Weapon(name, attackPoints, weight, owner)