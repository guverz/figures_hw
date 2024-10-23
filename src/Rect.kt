// сочетание определения класса и конструктора одновременно объявляет переменные и задаёт их значения
import kotlin.math.abs

class Rect(var x: Int, var y: Int, var width: Int, var height: Int) : Movable, Transforming, Figure(0) {

    // нужно явно указывать, что вы переопределяете метод
    override fun move(dx: Int, dy: Int) {
        x += dx; y += dy
    }

    // для каждого класса area() определяется по-своему
    override fun area(): Float {
        return (width*height).toFloat() // требуется явное приведение к вещественному числу
    }

    override fun resize(zoom: Int) {
        width *= zoom
        height *= zoom
    }

    override fun rotate(direction: RotateDirection, centerX: Int, centerY: Int) {
        val tempX = abs(centerX - x)
        val tempY = abs(centerY - y)
        val tempWidth = width
        val tempHeight = height
        width = tempHeight
        height = tempWidth
        when {
            x < centerX && y < centerY -> {
                when (direction) {
                    RotateDirection.Clockwise -> {
                        x = centerX - tempY; y = centerY + tempX
                    }
                    RotateDirection.CounterClockwise -> {
                        x = centerX + tempY; y = centerY - tempX
                    }
                }
            }
            x < centerX && y > centerY -> {
                when (direction) {
                    RotateDirection.Clockwise -> {
                        x = centerX + tempY; y = centerY + tempX
                    }
                    RotateDirection.CounterClockwise -> {
                        x = centerX - tempY; y = centerY - tempX
                    }
                }
            }
            x > centerX && y < centerY -> {
                when (direction) {
                    RotateDirection.Clockwise -> {
                        x = centerY - tempX; y = centerX - tempY
                    }
                    RotateDirection.CounterClockwise -> {
                        x = centerX + tempY; y = centerY + tempX
                    }
                }
            }
            x > centerX && y > centerY -> {
                when (direction) {
                    RotateDirection.Clockwise -> {
                        x = centerX + tempY; y = centerY - tempX
                    }
                    RotateDirection.CounterClockwise -> {
                        x = centerX + tempY; y = centerY - tempX
                    }
                }
            }
        }
    }

    override fun toString(): String {
        return "(${x}, ${y}), width $width, height $height"
    }
}