import kotlin.math.ceil
import kotlin.math.floor

fun main(){
    val console = System.console() ?: null
    println("逆ポーランド記法で計算したい文字列を入力してください。")
    println("独自ルールとして「,」を使用し二桁以上の数字を扱えます。")
    println("例：12,3+ -> 12 + 3")

    val formula = console?.readLine() ?: readLine() ?: ""
    if(formula.isBlank()) return

    val output = RPN(formula.split(" ").joinToString(separator = ""))
            .solve()
            .toDouble()
    if(floor(output) == ceil(output)) {
        val integer = output.toString().split(".")
        println(integer[0])
    }
    else println("result: %.2f".format(output))
}