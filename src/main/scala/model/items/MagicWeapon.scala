package cl.uchile.dcc.model.items
import cl.uchile.dcc.model.entities.Character
/**
 * Base class for magical weapons.
 * Magical weapons provide additional magic power for casting spells.
 *
 * @param name The name of the magic weapon.
 * @param attackPoints The physical attack damage.
 * @param weight The weight of the weapon.
 * @param owner The character who currently owns this weapon.
 * @param manaPower The magic damage or power added to spells when equipped.
 */
abstract class MagicWeapon(name: String, attackPoints: Int, weight: Int, owner: Character, val manaPower: Int) extends
  Weapon(name, attackPoints, weight, owner):
  override def isMagical: Boolean = true

