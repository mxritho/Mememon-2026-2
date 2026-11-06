package cl.uchile.dcc.model.items
import cl.uchile.dcc.model.entities.Character
/** Represents a Staff, a powerful magical weapon. */
class Staff(name: String, attackPoints: Int, weight: Int, owner: Character, manaPower: Int) extends MagicWeapon(name, attackPoints, weight, owner, manaPower)