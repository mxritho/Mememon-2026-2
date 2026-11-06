package cl.uchile.dcc.model.entities

abstract class AbstractUnit(val name: String, protected var _hp: Int, val weight: Int) extends Units:
  def hp: Int = _hp
  
  def receiveDamage(damage: Int): Unit = {
    val actualDamage = math.max(0, damage - defense)
    _hp -= actualDamage
    if (_hp < 0) _hp = 0
  }