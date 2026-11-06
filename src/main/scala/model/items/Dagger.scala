package cl.uchile.dcc.model.items
import cl.uchile.dcc.model.entities.Character
/** Represents a Dagger, a fast physical weapon. */
class Dagger(name: String, attackPoints: Int, weight: Int, owner: Character) extends Weapon(name, attackPoints, weight, owner)
