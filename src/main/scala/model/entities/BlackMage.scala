package cl.uchile.dcc.model.entities

import cl.uchile.dcc.model.items.Weapon
import cl.uchile.dcc.model.exceptions.RequerimentNotMeetException
/** Represents a Black Mage character capable of casting dark magic. */
class BlackMage(name: String, hp: Int, defense: Int, weight: Int, manaPoints: Int) extends MagicCharacter(name, hp, defense, weight, manaPoints):
  override def checkEquipRequeriments(weapon: Weapon): Unit = {
    if (!weapon.isDagger && !weapon.isWand && !weapon.isStaff) {
      throw new RequerimentNotMeetException(s"$name is a Black Mage and can only equip daggers, wands, or staffs")
    }
  }