package cl.uchile.dcc.controller

import cl.uchile.dcc.model.entities.Units
import cl.uchile.dcc.model.actions.{ActionTrait, Target}
import cl.uchile.dcc.model.exceptions.{InvalidMovementException, InvalidTargetException, RequerimentNotMeetException}
import cl.uchile.dcc.turnScheduler.TurnScheduler

class GameController {
  private val turnScheduler = new TurnScheduler()

  def addUnitToGame(unit: Units): Unit = {
    turnScheduler.addUnit(unit)
  }

  def getCurrentUnit: Option[Units] = {
    turnScheduler.getTurn()
  }

  def decideNextTurn(): Option[Units] = {
    while (getCurrentUnit.isEmpty) {
      turnScheduler.increaseAllActionBars(1.0)
    }
    getCurrentUnit
  }

  def getAvailableActions(unit: Units): List[ActionTrait] = {
    unit.availableActions
  }

  def executeAction(action: ActionTrait, target: Target): Unit = {
    val current = getCurrentUnit
    if (current.isDefined) {
      val sourceUnit = current.get
      try {
        sourceUnit.executeAction(action, target)
        turnScheduler.resetActionBar(sourceUnit)
      }
      catch {
        case e: RequerimentNotMeetException =>
          println(s"Action failed: ${e.getMessage}")
        case e: InvalidMovementException =>
          println(s"Invalid movement: ${e.getMessage}")
        case e: InvalidTargetException =>
          println(s"Invalid target: ${e.getMessage}")
      }
    }
  }

  def resetGameState(): Unit = {
    turnScheduler.calculateMaxActionBar().keys.foreach {unit => turnScheduler.resetActionBar(unit)}
  }
}