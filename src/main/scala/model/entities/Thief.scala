package cl.uchile.dcc.model.entities

import cl.uchile.dcc.model.exceptions.RequerimentNotMeetException
import cl.uchile.dcc.model.items.Weapon

/** Represents a Thief character. */
class Thief(name: String, hp: Int, defense: Int, weight: Int) extends Character(name, hp, defense, weight):
  override def checkEquipRequeriments(weapon: Weapon): Unit =
    if (!weapon.isSword && !weapon.isDagger) {
      throw new RequerimentNotMeetException(s"$name is a Thief and can only equip swords or daggers")
    }