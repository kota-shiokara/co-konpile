import java.lang.StringBuilder
import java.util.*

class RPN(private val input: String) {
    private var stack: Stack<String> = Stack<String>()
    var frontDigit: Int = 0
    var backDigit: Int = 0
    var digitFrag: Boolean = false

    fun solve() : String {
        for(c in input){
            when(c){
                '+' -> {
                    try {
                        var tmpNum: Double = calc(0)
                        stack.push(tmpNum.toString())
                    }catch (e: EmptyStackException){
                        e.printStackTrace()
                    }
                    digitFrag = false
                }
                '-' -> {
                    try {
                        var tmpNum: Double = calc(1)
                        stack.push(tmpNum.toString())
                    }catch (e: EmptyStackException){
                        e.printStackTrace()
                    }
                    digitFrag = false
                }
                '*' -> {
                    try {
                        var tmpNum: Double = calc(2)
                        stack.push(tmpNum.toString())
                    }catch (e: EmptyStackException){
                        e.printStackTrace()
                    }
                    digitFrag = false
                }
                '/' -> {
                    try {
                        var tmpNum: Double = calc(3)
                        stack.push(tmpNum.toString())
                    }catch (e: EmptyStackException){
                        e.printStackTrace()
                    }
                    digitFrag = false
                }
                ',' -> {
                    digitFrag = true
                }
                else -> {
                    try {
                        stack.push(c.toString())
                    }catch (e: EmptyStackException){
                        e.printStackTrace()
                    }
                    if(!digitFrag) frontDigit++
                    else backDigit++
                }
            }
        }
        val result = stack.pop().toString()
        return result
    }

    private fun calc(operator: Int): Double{
        var sb = StringBuilder()
        var tmpString: String
        var frontNum: Double
        var backNum: Double
        if(!digitFrag) {
            backDigit = 1
            frontDigit = 1
        }

       // println("backDigit: $backDigit")
        while (backDigit > 0){
            try {
                tmpString = stack.pop().toString()
                //print(tmpString)
                sb.append(tmpString)
            }catch (e: EmptyStackException){
                e.printStackTrace()
            }
            backDigit--
        }
        backNum = sb.reverse().toString().toDouble()
        /*println()
        println("backNum: $backNum")
        println("frontDigit: $frontDigit")*/
        sb.clear()
        while (frontDigit > 0){
            try {
                tmpString = stack.pop().toString()
                sb.append(tmpString)
                //print(tmpString)
            }catch (e: EmptyStackException){
                e.printStackTrace()
            }
            frontDigit--
        }
        if(digitFrag) frontNum = sb.reverse().toString().toDouble()
        else frontNum = sb.toString().toDouble()
        /*println()
        println("frontNum: $frontNum")*/

        return when(operator){
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