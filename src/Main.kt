
fun main() {

    val rect1: Figure = Rect(6, -3,4,2)
    val circle1: Figure = Circle(6, 1, 5)
    val sqr1: Figure = Square(4, -5, 3)

    println("|Rectangle|")
    println(rect1.toString())
    println(rect1.area())
    rect1.rotate(RotateDirection.Clockwise, 8, 2)
    println(rect1.toString())
    rect1.rotate(RotateDirection.CounterClockwise, 8, 2)
    println(rect1.toString())

    println("|Circle|")
    println(circle1.toString())
    println(circle1.area())
    circle1.rotate(RotateDirection.CounterClockwise, 4, 2)
    println(circle1.toString())
    circle1.rotate(RotateDirection.Clockwise, 4, 2)
    println(circle1.toString())

    println("|Square|")
    println(sqr1.toString())
    println(sqr1.area())
    sqr1.rotate(RotateDirection.Clockwise, 5, -4)
    println(sqr1.toString())
    sqr1.rotate(RotateDirection.CounterClockwise, 5, -4)
    println(sqr1.toString())

}