package cl.uchile.dcc.model.entities

import cl.uchile.dcc.model.items.Weapon
import cl.uchile.dcc.model.exceptions.RequerimentNotMeetException

/** Represents a White Mage character capable of casting light magic. */
class WhiteMage(name: String, hp: Int, defense: Int, weight: Int, manaPoints: Int) extends MagicCharacter(name, hp, defense, weight, manaPoints):
  override def checkEquipRequeriments(weapon: Weapon): Unit = {
    if (!weapon.isBow && !weapon.isWand && !weapon.isStaff) {
      throw new RequerimentNotMeetException(s"$name is a White Mage and can only equip bows, wands, or staffs")
    }
  }