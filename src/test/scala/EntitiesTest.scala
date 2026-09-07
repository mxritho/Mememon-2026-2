package models

class EntitiesTest extends munit.FunSuite:
  test("A Knight should be instantiated with correct attributes"):
    val knight = new Knight("Artorias", 100, 15, 50)
    assertEquals(knight.name, "Artorias")
    assertEquals(knight.hp, 100)
    assertEquals(knight.defense, 15)
    assertEquals(knight.weight, 50)
    assertEquals(knight.weaponSlot, None)
    assert(knight.inventory.isEmpty)

  test("A Player should hold a list of units and default to alive"):
    val knight = new Knight("Artorias", 100, 15, 50)
    val player = new Player(units = List(knight))
    assertEquals(player.units.length, 1)
    assert(player.isAlive)

  test("A Sword weapon should store its stats correctly"):
    val owner = new Knight("Dummy", 100, 10, 40)
    val sword = new Sword("Excalibur", 35, 10, owner)
    assertEquals(sword.name, "Excalibur")
    assertEquals(sword.attackPoints, 35)
    assertEquals(sword.weight, 10)
    assertEquals(sword.owner, owner)

  test("A Healing potion should have the default name"):
    val potion = new Healing()
    assertEquals(potion.name, "Healing Potion")