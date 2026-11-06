package cl.uchile.dcc.model.items

/**
 * Base class for all consumable potions in the game.
 *
 * @param name The name of the potion.
 */
abstract class Potion(name: String) extends AbstractItem(name)