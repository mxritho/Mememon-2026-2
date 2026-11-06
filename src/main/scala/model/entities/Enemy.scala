package cl.uchile.dcc.model.entities

import cl.uchile.dcc.model.actions.Source
import cl.uchile.dcc.model.actions.ActionTrait
import cl.uchile.dcc.model.exceptions.InvalidTargetException
import cl.uchile.dcc.model.actions.{Healing, Purification}

/**
 * Represents an enemy unit in the game.
 *
 * @param name The name of the enemy.
 * @param _hp The initial health points of the enemy.
 * @param attack The attack power of the enemy.
 * @param defense The defense points of the enemy.
 * @param weight The weight of the enemy, used to calculate its action bar.
 */
class Enemy(name: String, _hp: Int, val attack: Int, val defense: Int, weight: Int) extends AbstractUnit(name, _hp, weight):
  /**
   * Calculates the maximum action bar capacity for the enemy.
   * For enemies, it is strictly equal to their base weight.
   *
   * @return The action bar value as a Double.
   */
  override def actionBar: Double = weight.toDouble

  override def getAttackDamage: Int = this.attack

  def receiveAction(action: ActionTrait, source: Source): Unit =
    action.doAction(source, this)

  override def receiveHealing(action: Healing, source: Source): Unit =
    if (this.hp <= 0) throw new InvalidTargetException(s"$name is defeated and cannot receive actions")
    throw new InvalidTargetException(s"The unit $name is an enemy and cannot be healed")
  override def receivePurification(action: Purification, source: Source): Unit =
    if (this.hp <= 0) throw new InvalidTargetException(s"$name is defeated and cannot receive Purification")