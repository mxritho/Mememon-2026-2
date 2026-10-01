package cl.uchile.dcc
import map._
import actions._

class ActionAndPanelTest extends munit.FunSuite:

  test("Actions should have correct names") {
    assertEquals(Attack().name, "Attack")
    assertEquals(Move().name, "Move")
    assertEquals(EquipWeapon(List()).name, "Equip Weapon")
    assertEquals(ConsumePotion(List()).name, "Consume Potion")
    assertEquals(Thunder().name, "Thunder")
    assertEquals(Meteor().name, "Meteor")
    assertEquals(Healing().name, "Healing")
    assertEquals(Purification().name, "Purification")
  }

  test("Panel should store coordinates, units and adjacent panels") {
    val panel = Panel(1, 2)
    assertEquals(panel.x, 1)
    assertEquals(panel.y, 2)
    assert(panel.units.isEmpty)
    assert(panel.adjacentPanels.isEmpty)
  }