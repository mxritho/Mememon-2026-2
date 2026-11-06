package cl.uchile.dcc.model.actions

trait ActionTrait:
  val name: String
  def doAction(source: Source, target: Target): Unit
  