import java.lang.ClassCastException
import kotlin.math.ceil
import kotlin.math.floor

fun main() {
    val console = System.console() ?: null
    println("逆ポーランド記法で計算したい文字列を入力してください。")
    println("数字、演算子は空白で区切ってください。")
    println("例：12 3 + -> 12 + 3")

    while (true) {
        val formula = console?.readLine() ?: readLine() ?: ""
        if (formula.isBlank()) return
        else if (formula == "exit") break

        val output = RPN(formula.split(" ")).solve().toDouble()

        if (floor(output) == ceil(output)) {
            val integer = output.toString().split(".")
            println(integer[0])
        } else println("result: %.2f".format(output))


        print("Next formula: ")
    }
}