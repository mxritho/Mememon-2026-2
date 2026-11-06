# Proyecto Semestral: Final Reality Tactics

## Deciciones de Diseño
 1. Use polimorfismo mediante el trait 'Units' como base comun para los distintos tipos de unidades, esto permite que el TurnScheduler pueda trabajar tanto con personajes como con enemigos sin tener que implementar metodos diferentes para cada uno, dado que el controlador solo necesita trabajar con Units. 
2. Uso de Option[Weapon] para evitar trabajar con null, asi si un personaje tiene equipada un arma se utiliza None, del caso contrario se utiliza Some(Weapon).
3. Encapsulamiento y privacidad. Valores que pueden cambiar en el juego como los puntos de vida (_hp), defensa, inventario y arma equipada se mantienen como private var. Asi otras clases no pueden modificarlas directamente.
4. Manejo de turnos con un Map. Para el TurnScheduler decidi usar Map[Units, Double], donde la clave corresponde a una unidad y el valor asociado a esta llave representa el progreso de su barra de accion, asi evitamos tener distintas listas para guardar unidades y sus progresos. Ademas esto permite obtener facilmente las unidades que estan registradas mediante .keys.