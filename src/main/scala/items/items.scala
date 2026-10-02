package cl.uchile.dcc
package items
import entities.Character

/**
 * Base class for all weapons in the game.
 *
 * @param name The name of the weapon.
 * @param attackPoints The physical attack damage the weapon deals.
 * @param weight The weight of the weapon, which affects the character's turn speed.
 * @param owner The character who currently owns this weapon.
 */
abstract class Weapon(val name: String, val attackPoints: Int, val weight: Int, val owner: Character)

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
  Weapon(name, attackPoints, weight, owner)

/** Represents a Sword, a common physical weapon. */
class Sword(name: String, attackPoints: Int, weight: Int, owner: Character) extends Weapon(name, attackPoints, weight, owner)

/** Represents a Dagger, a fast physical weapon. */
class Dagger(name: String, attackPoints: Int, weight: Int, owner: Character) extends Weapon(name, attackPoints, weight, owner)

/** Represents a Bow, a ranged physical weapon. */
class Bow(name: String, attackPoints: Int, weight: Int, owner: Character) extends Weapon(name, attackPoints, weight, owner)

/** Represents a Wand, a magical weapon used by mages. */
class Wand(name: String, attackPoints: Int, weight: Int, owner: Character, manaPower: Int) extends MagicWeapon(name, attackPoints, weight, owner, manaPower)

/** Represents a Staff, a powerful magical weapon. */
class Staff(name: String, attackPoints: Int, weight: Int, owner: Character, manaPower: Int) extends MagicWeapon(name, attackPoints, weight, owner, manaPower)

/**
 * Base class for all consumable potions in the game.
 *
 * @param name The name of the potion.
 */
abstract class Potion(val name: String)

/** A potion that restores a percentage of the consumer's maximum health. */
class Healing(name: String = "Healing Potion") extends Potion(name)

/** A potion that increases the consumer's defense. */
class Strength(name: String = "Strength Potion") extends Potion(name)

/** A potion that restores a percentage of the consumer's maximum mana. */
class Mana(name: String = "Mana Potion") extends Potion(name)

/** A potion that increases the magic damage of the next spell. */
class MagicStrength(name: String = "Magic Strength Potion") extends Potion(name)