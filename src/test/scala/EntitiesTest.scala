package cl.uchile.dcc
import entities._

class EntitiesTest extends munit.FunSuite:
  test("A Character should initialize correctly with their base attributes"):
    val knight = new Knight("Arthur", 100, 15, 50)
    val thief = new Thief("Theo", 70, 20, 35)
    assertEquals(knight.name, "Arthur")
    assertEquals(knight.hp, 100)
    assertEquals(knight.defense, 15)
    assertEquals(knight.weight, 50)
    assertEquals(thief.name, "Theo")
    assertEquals(knight.weaponSlot, None)
    assertEquals(thief.weaponSlot, None)

  test("A Magic Character should be initializated with their base attributes"):
    val whitemage = new WhiteMage("Gandalf", 65, 20, 35, 200)
    val blackmage = new BlackMage("Voldemort", 60, 15, 30, 150)

    assertEquals(whitemage.name, "Gandalf")
    assertEquals(blackmage.name, "Voldemort")
    assertEquals(whitemage.hp, 65)
    assertEquals(blackmage.hp, 60)
    assertEquals(blackmage.manaPoints, 150)
    assertEquals(whitemage.manaPoints, 200)

  test("A Player should hold a list of units and default to alive"):
    val knight = new Knight("Artorias", 100, 15, 50)
    val player = new Player(List(knight))
    assertEquals(player.units.length, 1)
    assertEquals(player.isAlive, true)

  test("An enemy should initialize correctly with their base attributes"):
    val mortifagos = Enemy("Mortifagos", 40, 20, 10, 20)
    assertEquals(mortifagos.name, "Mortifagos")
    assertEquals(mortifagos.hp, 40)
    assertEquals(mortifagos.attack, 20)
    assertEquals(mortifagos.defense, 10)
    assertEquals(mortifagos.weight, 20)

