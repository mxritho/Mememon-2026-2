package cl.uchile.dcc
import entities.Units

/**
 * Controller class responsible for managing the turn order of units in combat.
 * It uses an action bar system based on the unit's weight and equipped weapon.
 */
class TurnScheduler:
  private var unitProgress: Map[Units, Double] = Map()

  /**
   * Adds a new unit to the turn scheduler.
   *
   * @param unit The combat unit to be added to the scheduler.
   */
  def addUnit(unit: Units): Unit =
    if (!unitProgress.contains(unit)) {
      unitProgress += (unit -> 0.0)
    }

  /**
   * Removes a unit from the turn scheduler.
   *
   * @param unit The combat unit to be removed.
   */
  def removeUnit(unit: Units) : Unit =
    unitProgress -= unit

  /**
   * Calculates the maximum action bar value for all registered units.
   *
   * @return A map containing each unit and its respective maximum action bar capacity.
   */
  def calculateMaxActionBar(): Map[Units, Double] =
    unitProgress.keys.map(units => units -> units.actionBar).toMap

  /**
   * Resets the action bar progress of a specific unit to zero.
   *
   * @param unit The unit whose action bar will be reset.
   */
  def resetActionBar(unit: Units): Unit =
    if (unitProgress.contains(unit)) {
      unitProgress = unitProgress.updated(unit, 0.0)
    }

  /**
   * Increases the action bar progress of all units by a fixed arbitrary amount.
   *
   * @param k The amount to increase all action bars by.
   */
  def increaseAllActionBars(k: Double): Unit =
    for (unit <- unitProgress.keys) {
      val currentBar = unitProgress(unit)
      unitProgress = unitProgress.updated(unit, currentBar + k)
    }

  /**
   * Checks if a specific unit has completed its action bar.
   *
   * @param unit The unit to check.
   * @return True if the unit's progress is greater than or equal to its maximum action bar, false otherwise.
   */
  def isActionBarCompleted(unit: Units): Boolean =
    if (unitProgress.contains(unit)) {
      val currentBar = unitProgress(unit)
      currentBar >= unit.actionBar
    } else {
      false
    }

  /**
   * Retrieves a list of all units that have completed their action bar, ordered by their surplus.
   * Units with a higher surplus (current progress minus max action bar) have higher priority.
   *
   * @return A sorted list of ready units.
   */
  def readyInOrder(): List[Units] = {
    var readyList: List[Units] = List()
    for (unit <- unitProgress.keys) {
      if (isActionBarCompleted(unit)) {
        readyList = readyList :+ unit
      }
    }
    val sortedList = readyList.sortBy { unit =>
      val currentBar = unitProgress(unit)
      val actionBar = unit.actionBar
      currentBar - actionBar
    }(Ordering[Double].reverse)
    sortedList
  }

  /**
   * Gets the next unit that should take a turn in combat.
   *
   * @return An Option containing the unit with the highest priority, or None if no unit is ready.
   */
  def getTurn(): Option[Units] =
    readyInOrder().headOption