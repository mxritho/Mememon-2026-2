package cl.uchile.dcc
package map
import entities.Units

class Panel(val x: Int, val y: Int):
  private var _units: List[Units] = List()
  private var _adjacentPanels: List[Panel] = List()
  def units: List[Units] = _units
  def adjacentPanels: List[Panel] = List()

