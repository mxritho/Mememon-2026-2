package cl.uchile.dcc.model.actions

/**
 * Base trait for all actions.
 */
trait ActionTrait:
  val name: String
  def doAction(source: Source, target: Target): Unit