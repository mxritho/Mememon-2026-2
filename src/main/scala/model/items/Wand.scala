package cl.uchile.dcc.model.items
import cl.uchile.dcc.model.entities.Character
/** Represents a Wand, a magical weapon used by mages. */
class Wand(name: String, attackPoints: Int, weight: Int, owner: Character, manaPower: Int) 
  extends MagicWeapon(name, attackPoints, weight, owner, manaPower):
  override def isWand: Boolean = true
