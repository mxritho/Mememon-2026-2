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
    unitProgress.keys.map(Units => Units -> Units.actionBar).toMap





