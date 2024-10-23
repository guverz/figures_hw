import kotlin.math.abs

// TODO: дополнить определение класса размерами и позицией
class Square(var x: Int, var y: Int, var size: Int) : Figure(1), Transforming, Movable {

    override fun area(): Float {
        return (size*size).toFloat()
    }

    override fun resize(zoom: Int) {
        size *= zoom
    }

    override fun rotate(direction: RotateDirection, centerX: Int, centerY: Int) {
        val tempX = abs(centerX - x)
        val tempY = abs(centerY - y)
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


    override fun move(dx: Int, dy: Int) {
        x += dx; y += dy
    }

    override fun toString(): String {
        return "(${x}, ${y}), size $size"
    }
}