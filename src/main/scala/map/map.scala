package cl.uchile.dcc
package map
import entities.Units

/**
 * Represents a single grid tile (panel) on the game map where units can be positioned.
 *
 * @param x The horizontal coordinate of the panel.
 * @param y The vertical coordinate of the panel.
 */
class Panel(val x: Int, val y: Int):
  private var _units: List[Units] = List()
  private var _adjacentPanels: List[Panel] = List()

  /** @return A list of all units currently located in this panel. */
  def units: List[Units] = _units

  /** @return A list of all panels directly adjacent to this one. */
  def adjacentPanels: List[Panel] = _adjacentPanels