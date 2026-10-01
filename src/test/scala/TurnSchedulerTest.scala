package cl.uchile.dcc
import entities._

class turnSchedulerTest extends munit.FunSuite:
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



