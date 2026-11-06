package cl.uchile.dcc.model.actions
import cl.uchile.dcc.model.items.{Potion}

/**
 * Action that allows a character to consume a potion from their inventory.
 *
 * @param usables The list of potions available to be consumed.
 */
class ConsumePotion(val usables: List[Potion]) extends Action("Consume Potion")