package cl.uchile.dcc
import entities.{Knight,WhiteMage}
import items._

class ItemsTest extends munit.FunSuite:
  var knight: Knight = null
  var mage: WhiteMage = null

  override def beforeEach(context: BeforeEach): Unit = {
    knight = Knight("Arthur", 100, 50, 80)
    mage = WhiteMage("Merlin", 70, 20, 40, 100)
  }

  test("A Sword should be initialized correctly with its attributes") {
    val sword = Sword("Excalibur", 30, 15, knight)
    assertEquals(sword.name, "Excalibur")
    assertEquals(sword.attackPoints, 30)
    assertEquals(sword.weight, 15)
    assertEquals(sword.owner, knight)
  }

  test("A Dagger should be initialized correctly with its attributes") {
    val dagger = Dagger("Iron Dagger", 10, 5, knight)
    assertEquals(dagger.name, "Iron Dagger")
    assertEquals(dagger.attackPoints, 10)
    assertEquals(dagger.weight, 5)
    assertEquals(dagger.owner, knight)
  }

  test("A Bow should be initialized correctly with its attributes") {
    val bow = Bow("Stormwind", 20, 10, knight)
    assertEquals(bow.name, "Stormwind")
    assertEquals(bow.attackPoints, 20)
    assertEquals(bow.weight, 10)
    assertEquals(bow.owner, knight)
  }

  test("A Wand should be initialized correctly with its attributes and manaPower") {
    val wand = Wand("The Elder Wand", 5, 3, mage, 40)
    assertEquals(wand.name, "The Elder Wand")
    assertEquals(wand.attackPoints, 5)
    assertEquals(wand.weight, 3)
    assertEquals(wand.owner, mage)
    assertEquals(wand.manaPower, 40)
  }

  test("A Staff should be initialized correctly with its attributes and manaPower") {
    val staff = Staff("Emberfall Staff", 15, 8, mage, 60)
    assertEquals(staff.name, "Emberfall Staff")
    assertEquals(staff.attackPoints, 15)
    assertEquals(staff.weight, 8)
    assertEquals(staff.owner, mage)
    assertEquals(staff.manaPower, 60)
  }

  test("Potions should initialize with their default names") {
    val healing = Healing()
    val strength = Strength()
    val mana = Mana()
    val magicStrength = MagicStrength()

    assertEquals(healing.name, "Healing Potion")
    assertEquals(strength.name, "Strength Potion")
    assertEquals(mana.name, "Mana Potion")
    assertEquals(magicStrength.name, "Magic Strength Potion")
  }

  test("Potions can be instantiated with custom names") {
    val massiveHealing = Healing("Massive Healing Potion")
    assertEquals(massiveHealing.name, "Massive Healing Potion")
  }




