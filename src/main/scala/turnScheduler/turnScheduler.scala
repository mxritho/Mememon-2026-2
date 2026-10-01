package turnScheduler
import entities.Units

class turnScheduler:
  private var actionBars: Map[Units, Double] = Map()
  def addUnit(unit: Units): Unit =
    if (!actionBars.contains(unit)) {
      actionBars += (unit -> 0.0) }

  def removeUnit(unit: Units) : Unit =
    actionBars -= unit

