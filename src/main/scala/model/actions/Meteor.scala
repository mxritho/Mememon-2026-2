package cl.uchile.dcc.model.actions

/** Dark magic spell action that deals Area of Effect (AoE) magic damage to a panel. */
class Meteor extends Action("Meteor"):
  override def doAction(source: Source, target: Target): Unit =
    target.receiveMeteor(this, source)