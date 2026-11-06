package cl.uchile.dcc.model.EP4test

import cl.uchile.dcc.model.entities.*
import cl.uchile.dcc.model.map.Panel
import cl.uchile.dcc.model.actions.{EquipWeapon, Healing, Move, Purification, Thunder}
import cl.uchile.dcc.model.exceptions.*
import cl.uchile.dcc.controller.GameController
import cl.uchile.dcc.model.items.{Bow, Dagger}

class EP4Test extends munit.FunSuite {
  var knight: Knight = null
  var deadKnight: Knight = null
  var thief: Thief = null
  var enemy: Enemy = null
  var mage: BlackMage = null
  var panelOrigen: Panel = null
  var panelAdyacente: Panel = null
  var panelLejano: Panel = null
  var healing: Healing = null
  var purification: Purification = null
  var thunder: Thunder = null
  var controller: GameController = null

  override def beforeEach(context: BeforeEach): Unit = {
    knight = new Knight("Galahad", 117, 43, 76)
    deadKnight = new Knight("Dead Galahad", 0, 37, 69)
    thief = new Thief("Jesse James", 93, 28, 57)
    enemy = new Enemy("Coringa", 86, 17, 13, 24)
    mage = new BlackMage("Vivian", 109, 23, 38, 12)
    panelOrigen = new Panel(2, 3)
    panelAdyacente = new Panel(2, 4)
    panelLejano = new Panel(7, 9)
    panelOrigen.addAdjacentPanel(panelAdyacente)
    panelOrigen.addUnit(knight)
    healing = new Healing()
    purification = new Purification()
    thunder = new Thunder()
    controller = new GameController()
    controller.addUnitToGame(knight)
  }

  test("A unit can only move to an adjacent panel") {
    val moveAction = new Move(panelOrigen)
    intercept[InvalidMovementException] {
      panelLejano.receiveMove(moveAction, knight)
    }
    panelAdyacente.receiveMove(moveAction, knight)
    assert(!panelOrigen.units.contains(knight))
    assert(panelAdyacente.units.contains(knight))
  }

  test("Invalid targets should not receive these actions") {
    intercept[InvalidTargetException] {
      knight.receivePurification(purification, enemy)
    }
    intercept[InvalidTargetException] {
      enemy.receiveHealing(healing, knight)
    }
    intercept[InvalidTargetException] {
      panelOrigen.receiveHealing(healing, knight)
    }
    intercept[InvalidTargetException] {
      panelOrigen.receivePurification(purification, knight)
    }
  }

  test("Characters can only equip allowed weapons") {
    val bow = new Bow("Longbow", 23, 14, thief)
    val dagger = new Dagger("Bloody Dagger", 17, 9, thief)
    val equipInvalid = new EquipWeapon(List(bow), bow)
    val equipValid = new EquipWeapon(List(dagger), dagger)
    intercept[RequerimentNotMeetException] {
      thief.receiveEquipWeapon(equipInvalid, thief)
    }
    thief.receiveEquipWeapon(equipValid, thief)
    assert(thief.weaponSlot.isDefined)
    assertEquals(thief.weaponSlot.get, dagger)
  }
  test("A defeated unit cannot receive actions") {
    val deadEnemy = new Enemy("Dead Goblin", 0, 16, 12, 19)
    intercept[InvalidTargetException] {
      deadKnight.receiveHealing(healing, deadKnight)
    }
    intercept[InvalidTargetException] {
      deadKnight.receiveThunder(thunder, deadEnemy)
    }
    intercept[InvalidTargetException] {
      deadEnemy.receivePurification(purification, knight)
    }
  }

  test("Executing an invalid action should not crash the game") {
    controller.executeAction(healing, enemy)
    assert(controller != null)
  }
}
