package cl.uchile.dcc.model.actions
import cl.uchile.dcc.model.items.{Weapon}

/**
 * Action that allows a character to equip a weapon from their available options.
 *
 * @param usables The list of weapons available to be equipped.
 */
class EquipWeapon(val usables: List[Weapon]) extends Action("Equip Weapon")