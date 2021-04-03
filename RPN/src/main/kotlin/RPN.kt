import java.lang.StringBuilder
import java.util.*

class RPN(private val input: List<String>) {
    private var stack: Stack<String> = Stack<String>()

    fun solve(): String {
        for (c in input) {
            when (c) {
                "+" -> {
                    try {
                        var tmpNum: Double = calc(0)
                        stack.push(tmpNum.toString())
                    } catch (e: EmptyStackException) {
                        e.printStackTrace()
                    }
                }
                "-" -> {
                    try {
                        var tmpNum: Double = calc(1)
                        stack.push(tmpNum.toString())
                    } catch (e: EmptyStackException) {
                        e.printStackTrace()
                    }
                }
                "*" -> {
                    try {
                        var tmpNum: Double = calc(2)
                        stack.push(tmpNum.toString())
                    } catch (e: EmptyStackException) {
                        e.printStackTrace()
                    }
                }
                "/" -> {
                    try {
                        var tmpNum: Double = calc(3)
                        stack.push(tmpNum.toString())
                    } catch (e: EmptyStackException) {
                        e.printStackTrace()
                    }
                }
                else -> {
                    try {
                        stack.push(c)
                    } catch (e: EmptyStackException) {
                        e.printStackTrace()
                    }
                }
            }
        }
        val result = stack.pop().toString()
        return result
    }

    private fun calc(operator: Int): Double {
        var frontNum: Double = 0.0
        var backNum: Double = 0.0

        // println("backDigit: $backDigit")

        try {
            //print(tmpString)
            backNum = stack.pop().toString().toDouble()
        } catch (e: EmptyStackException) {
            e.printStackTrace()
        }

        /*println()
        println("backNum: $backNum")
        println("frontDigit: $frontDigit")*/
        try {
            frontNum = stack.pop().toString().toDouble()
        } catch (e: EmptyStackException) {
            e.printStackTrace()
        }
        /*println()
        println("frontNum: $frontNum")*/

        return when (operator) {
            0 -> {
                frontNum + backNum
            }
            1 -> {
                frontNum - backNum
            }
            2 -> {
                frontNum * backNum
            }
            3 -> {
                frontNum / backNum
            }
            else -> {
                0.0
            }
        }
    }
}