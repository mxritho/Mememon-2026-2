package cl.uchile.dcc.model.actions

/** Dark magic spell action that deals single-target magic damage. */
class Thunder extends Action("Thunder"):
  override def doAction(source: Source, target: Target): Unit = {
    source.checkMagicRequeriments(20)
    target.receiveThunder(this, source)
  }