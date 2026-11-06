package cl.uchile.dcc.model.actions

/**
 * Base abstract class for all actions that can be performed during a unit's turn.
 *
 * @param name The name of the action.
 */
abstract class Action(val name: String) extends ActionTrait:
  override def doAction(source: Source, target: Target): Unit