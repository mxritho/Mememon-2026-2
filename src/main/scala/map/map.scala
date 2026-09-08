package map

class Panel(val x: Int, val y: Int):
  var units: List[Any] = List()
  var adjacentPanels: List[Panel] = List()


