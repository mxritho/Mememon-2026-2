package cl.uchile.dcc
import entities._

class TurnSchedulerTest extends munit.FunSuite:
  var scheduler: TurnScheduler = null
  var knight: Knight = null
  var globin: Enemy = null

  override def beforeEach(context: BeforeEach): Unit = {
    scheduler = new TurnScheduler()
    knight = new Knight("Rodrigo", 75, 50, 90)
    globin = new Enemy("Globin", 30, 20, 15, 30)
  }

  test("addUnit should add units to the turn scheduler"):
    scheduler.addUnit(knight)
    val currentUnits = scheduler.calculateMaxActionBar()
    assert(currentUnits.contains(knight))
    assertEquals(currentUnits.size, 1)
    scheduler.addUnit(globin)
    val newCurrentUnits = scheduler.calculateMaxActionBar()
    assertEquals(newCurrentUnits.size,2)

  test("removeUnit should remove units from the turn scheduler"):
    scheduler.addUnit(knight)
    scheduler.addUnit(globin)
    scheduler.removeUnit(globin)
    val currentUnits = scheduler.calculateMaxActionBar()
    assertEquals(currentUnits.size,1)

  test("calculateMaxActionBar should return the correct stat for max bar"):
    scheduler.addUnit(knight)
    scheduler.addUnit(globin)
    val newCurrentUnits = scheduler.calculateMaxActionBar()
    assertEquals(newCurrentUnits(knight), 90.0)
    assertEquals(newCurrentUnits(globin), 30.0)

  test("resetActionBar should set the unit action bar to zero"):
    scheduler.addUnit(knight)
    scheduler.increaseAllActionBars(90)
    assert(scheduler.isActionBarCompleted(knight))
    scheduler.resetActionBar(knight)
    assert(!scheduler.isActionBarCompleted(knight))

  test("increaseAllActionBars should increase action bar for each unit, isActionBarCompleted should check if unit bar is completed"):
    scheduler.addUnit(knight)
    assert(!scheduler.isActionBarCompleted(knight))
    scheduler.increaseAllActionBars(20)
    assert(!scheduler.isActionBarCompleted(knight))
    scheduler.increaseAllActionBars(71)
    assert(scheduler.isActionBarCompleted(knight))

  test("readyInOrder should return the units sorted by its surplus"):
    scheduler.addUnit(knight)
    scheduler.addUnit(globin)
    scheduler.increaseAllActionBars(100)
    val sortedList = scheduler.readyInOrder()
    assertEquals(sortedList(0),globin)
    assertEquals(sortedList(1),knight)

  test("getTurn should return the unit first in the list"):
    assertEquals(scheduler.getTurn(), None)
    scheduler.addUnit(knight)
    scheduler.addUnit(globin)
    scheduler.increaseAllActionBars(100)
    assertEquals(scheduler.getTurn(),Some(globin))
