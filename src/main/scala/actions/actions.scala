package cl.uchile.dcc
package actions
import items.Weapon
import items.Potion

/**
 * Base class for all actions that can be performed during a unit's turn.
 *
 * @param name The name of the action.
 */
abstract class Action(val name: String)

/** Action that allows a unit to physically attack an enemy target. */
class Attack extends Action("Attack")

/** Action that allows a unit to move to an adjacent panel on the map. */
class Move extends Action("Move")

/**
 * Action that allows a character to equip a weapon from their available options.
 *
 * @param usables The list of weapons available to be equipped.
 */
class EquipWeapon(val usables: List[Weapon]) extends Action("Equip Weapon")

/**
 * Action that allows a character to consume a potion from their inventory.
 *
 * @param usables The list of potions available to be consumed.
 */
class ConsumePotion(val usables: List[Potion]) extends Action("Consume Potion")

/** Dark magic spell action that deals single-target magic damage. */
class Thunder extends Action("Thunder")

/** Dark magic spell action that deals Area of Effect (AoE) magic damage to a panel. */
class Meteor extends Action("Meteor")

/** Light magic spell action that heals a target unit. */
class Healing extends Action("Healing")

/** Light magic spell action that curses an enemy, reducing their current HP. */
class Purification extends Action("Purification")