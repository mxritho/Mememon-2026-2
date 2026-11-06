package cl.uchile.dcc.controller

import cl.uchile.dcc.model.entities.{Knight, Enemy}
import cl.uchile.dcc.model.actions.Attack

class GameControllerTest extends munit.FunSuite {

  var controller: GameController = null
  var knight: Knight = null
  var goblin: Enemy = null
  var attack: Attack = null

  override def beforeEach(context: BeforeEach): Unit = {
    controller = new GameController()
    knight = new Knight("Arthur", 100, 50, 80)
    goblin = new Enemy("Goblin", 40, 25, 10, 20)
    attack = new Attack()
  }

  test("getCurrentUnit should return None at the beginning when no unit has a full action bar") {
    controller.addUnitToGame(knight)
    assertEquals(controller.getCurrentUnit, None)
  }

  test("decideNextTurn should advance until a unit is ready to take a turn") {
    controller.addUnitToGame(knight)
    controller.addUnitToGame(goblin)
    val nextUnit = controller.decideNextTurn()
    assert(nextUnit.isDefined)
    assertEquals(nextUnit.get.name, "Goblin")
  }

  test("getAvailableActions should return the list of available actions for the unit") {
    val actions = controller.getAvailableActions(knight)
    assert(actions != null)
  }

  test("executeAction should end the current turn after executing an attack") {
    controller.addUnitToGame(knight)
    controller.addUnitToGame(goblin)
    controller.decideNextTurn()
    assert(controller.getCurrentUnit.isDefined)
    controller.executeAction(attack, knight)
    assertEquals(controller.getCurrentUnit, None)
  }

  test("resetGameState should reset the current turn") {
    controller.addUnitToGame(knight)
    controller.addUnitToGame(goblin)
    controller.decideNextTurn()
    assert(controller.getCurrentUnit.isDefined)
    controller.resetGameState()
    assertEquals(controller.getCurrentUnit, None)
  }
}
