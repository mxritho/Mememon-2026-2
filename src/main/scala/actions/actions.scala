package actions
import models.Weapon
import models.Potion

abstract class Action(val name: String)

class Attack extends Action("Attack")
class Move extends Action("Move")
class EquipWeapon(val usables: List[Weapon]) extends Action("Equip Weapon")
class ConsumePotion(val usables: List[Potion]) extends Action("Consume Potion")
class Thunder extends Action("Thunder")
class Meteor extends Action("Meteor")
class Healing extends Action("Healing")
class Purification extends Action("Purification")

