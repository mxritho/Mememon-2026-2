package cl.uchile.dcc.model.actions

/** Light magic spell action that heals a target unit. */
class Healing extends Action("Healing"):
  override def doAction(source: Source, target: Target): Unit =
    target.receiveHealing(this, source)