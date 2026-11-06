package cl.uchile.dcc.model.entities

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