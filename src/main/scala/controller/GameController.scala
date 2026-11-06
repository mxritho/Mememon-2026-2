package cl.uchile.dcc.controller

import cl.uchile.dcc.model.entities.Units
import cl.uchile.dcc.model.actions.{ActionTrait, Target}
import cl.uchile.dcc.model.exceptions.{InvalidMovementException, InvalidTargetException, RequerimentNotMeetException}
import cl.uchile.dcc.turnScheduler.TurnScheduler

/**
 * Controller responsible for managing the flow of the game, including units and turns.
 */
class GameController {
  private val turnScheduler = new TurnScheduler()

  /**
   * Adds a new unit to the game and the turn scheduler.
   *
   * @param unit The unit to be added.
   */
  def addUnitToGame(unit: Units): Unit = {
    turnScheduler.addUnit(unit)
  }

  /**
   * Retrieves the unit whose turn it is currently.
   *
   * @return An Option containing the current unit, or None if no unit is ready.
   */
  def getCurrentUnit: Option[Units] = {
    turnScheduler.getTurn()
  }

  /**
   * Advances the game state until a unit is ready to take its turn.
   *
   * @return An Option containing the unit whose turn is next.
   */
  def decideNextTurn(): Option[Units] = {
    while (getCurrentUnit.isEmpty) {
      turnScheduler.increaseAllActionBars(1.0)
    }
    getCurrentUnit
  }

  /**
   * Gets the list of available actions for a specific unit.
   *
   * @param unit The unit to query.
   * @return A list of available actions for the unit.
   */
  def getAvailableActions(unit: Units): List[ActionTrait] = {
    unit.availableActions
  }

  /**
   * Executes an action from the current unit against a target.
   * Catches and handles game rule exceptions.
   *
   * @param action The action to execute.
   * @param target The target of the action.
   */
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

  /**
   * Resets the game state by setting all units' action bars back to zero.
   */
  def resetGameState(): Unit = {
    turnScheduler.calculateMaxActionBar().keys.foreach {unit => turnScheduler.resetActionBar(unit)}
  }
}