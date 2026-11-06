package cl.uchile.dcc.model.entities

import cl.uchile.dcc.model.exceptions.RequerimentNotMeetException
import cl.uchile.dcc.model.items.Weapon

/** Represents an Archer character. */
class Archer(name: String, hp: Int, defense: Int, weight: Int) extends Character(name, hp, defense, weight):
  override def checkEquipRequeriments(weapon: Weapon): Unit =
    if (!weapon.isSword && !weapon.isBow && !weapon.isWand)
      throw new RequerimentNotMeetException(s"$name is an Archer and can only equip swords, bows, or wands")