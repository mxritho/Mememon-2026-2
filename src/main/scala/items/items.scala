package items
import entities.Character

abstract class Weapon(val name: String, val attackPoints: Int, val weight: Int,val owner: Character)

abstract class MagicWeapon(name: String, attackPoints: Int, weight: Int, owner: Character, val manaPower: Int) extends
  Weapon(name, attackPoints, weight, owner)

class Sword(name: String, attackPoints: Int, weight: Int, owner: Character) extends Weapon(name,attackPoints,weight,owner)
class Dagger( name: String, attackPoints: Int, weight: Int, owner: Character) extends Weapon(name,attackPoints,weight,owner)
class Bow (name: String, attackPoints: Int, weight: Int, owner: Character) extends Weapon(name,attackPoints,weight,owner)
class Wand( name: String, attackPoints: Int, weight: Int, owner: Character, manaPower: Int) extends MagicWeapon(name, attackPoints, weight, owner, manaPower)
class Staff( name: String, attackPoints: Int, weight: Int, owner: Character, manaPower: Int) extends MagicWeapon(name, attackPoints, weight, owner, manaPower)

abstract class Potion(val name: String)

class Healing(name: String = "Healing Potion") extends Potion(name)
class Strength(name: String = "Strength Potion") extends Potion(name)
class Mana(name: String = "Mana Potion") extends Potion(name)
class MagicStrength(name: String = "Magic Strength Potion") extends Potion(name)

