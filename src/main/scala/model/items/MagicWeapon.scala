package cl.uchile.dcc.model.items
import cl.uchile.dcc.model.entities.Character
/**
 * Base class for magical weapons providing additional magic power for casting spells.
 */
abstract class MagicWeapon(name: String, attackPoints: Int, weight: Int, owner: Character, val manaPower: Int) extends Weapon(name, attackPoints, weight, owner):
  override def isMagical: Boolean = true