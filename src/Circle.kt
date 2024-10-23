// TODO: дополнить определение класса размерами и позицией

import kotlin.math.PI
import kotlin.math.abs
import kotlin.math.pow

class Circle(var x: Int, var y: Int, var rad: Int) : Figure(2) {
    override fun area(): Float {
        return (PI * rad.toDouble().pow(2)).toFloat()
    }

    override fun resize(zoom: Int) {
        rad *= zoom
    }

    override fun move(dx: Int, dy: Int) {
        x += dx; y += dy
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
    override fun toString(): String {
        return "(${x}, ${y}), size $rad"
    }

}