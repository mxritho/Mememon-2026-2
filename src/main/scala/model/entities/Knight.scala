package cl.uchile.dcc.model.entities

import cl.uchile.dcc.model.exceptions.RequerimentNotMeetException
import cl.uchile.dcc.model.items.Weapon

/** Represents a Knight character. */
class Knight(name: String, hp: Int, defense: Int, weight: Int) extends Character(name, hp, defense, weight):
  override def checkEquipRequeriments(weapon: Weapon): Unit =
    if (!weapon.isSword && !weapon.isDagger && !weapon.isBow) 
      throw new RequerimentNotMeetException(s"$name is a Knight and can only equip swords, daggers, or bows")