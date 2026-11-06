package cl.uchile.dcc.model.actions

/** Light magic spell action that curses an enemy, reducing their current HP. */
class Purification extends Action("Purification"):
  override def doAction(source: Source, target: Target): Unit =
    target.receivePurification(this, source)