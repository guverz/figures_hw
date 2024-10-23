
fun main() {

    // интерфейсы удобно использовать в коллекциях
//    val figures: Array<Movable>
//    val movable: Movable = Rect(0,0,1,1)
//    movable.move(1,1)
    // переменной базового класса
    val f: Figure = Rect(6, -3,4,2)
    val f2: Figure = Circle(6, 1, 5)

    println(f.area())
    println(f2.area())
    f.rotate(RotateDirection.Clockwise, 8, 2)
    println(f.toString())

}