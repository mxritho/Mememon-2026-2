package cl.uchile.dcc.model.exceptions

/** Exception thrown when an invalid action is attempted. */
class InvalidActionException(message: String) extends Exception(message)

/** Exception thrown when an invalid movement is attempted. */
class InvalidMovementException(message: String) extends Exception(message)

/** Exception thrown when an invalid target is selected for an action. */
class InvalidTargetException(message: String) extends Exception(message)

/** Exception thrown when a requirement to perform an action is not met. */
class RequerimentNotMeetException(message: String) extends Exception(message)