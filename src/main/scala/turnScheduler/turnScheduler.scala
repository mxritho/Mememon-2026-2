package cl.uchile.dcc
import entities.Units

class TurnScheduler:
  private var unitProgress: Map[Units, Double] = Map()

  def addUnit(unit: Units): Unit =
    if (!unitProgress.contains(unit)) {
      unitProgress += (unit -> 0.0) }

  def removeUnit(unit: Units) : Unit =
    unitProgress -= unit

  def calculateMaxActionBar(): Map[Units, Double] =
    unitProgress.keys.map(units => units -> units.actionBar).toMap

  def resetActionBar(unit: Units): Unit =
    if (unitProgress.contains(unit)) {
      unitProgress = unitProgress.updated(unit, 0.0)
    }

  def increaseAllActionBars(k: Double): Unit =
    for (unit <- unitProgress.keys) {
      val currentBar = unitProgress(unit)
      unitProgress = unitProgress.updated(unit, currentBar + k)
    }

  def isActionBarCompleted(unit: Units): Boolean =
    if (unitProgress.contains(unit)) {
      val currentBar = unitProgress(unit)
      currentBar >= unit.actionBar
    } else {
      false
    }

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
  
  
  
  





