package cl.uchile.dcc.model.items
import cl.uchile.dcc.model.entities.Character
/**
 * Base class for all weapons in the game.
 *
 * @param name The name of the weapon.
 * @param attackPoints The physical attack damage the weapon deals.
 * @param weight The weight of the weapon, which affects the character's turn speed.
 * @param owner The character who currently owns this weapon.
 */
abstract class Weapon(name: String, val attackPoints: Int, val weight: Int, val owner: Character) extends AbstractItem(name)