import kotlin.math.sqrt

class Eratosthenes(private val N: Long){
    private var primeList: MutableList<Boolean> = (0..N).map {
        when {
            it == 2.toLong() -> {
                true
            }
            it % 2 == 0.toLong() -> {
                false
            }
            else -> {
                true
            }
        }}.toMutableList()
    private var ans : Long = 0

    fun solve(): Eratosthenes = apply {
        primeList[0] = false
        primeList[1] = false
        var i = 2
        val sqrt = sqrt(N.toDouble()).toLong()
        //primeList.forEachIndexed{ idx, value -> when{ idx % 2 == 0 -> {println("${idx}: ${value}")} }}
        //primeList.filter { it }.forEachIndexed{ idx, value -> println("${idx}") }
        while(i < sqrt) {
            if(primeList[i]){
                var j = i*i
                while(j < N){
                    primeList[j] = false
                    j += i
                }
            }
            if(i == 2) i++
            else i += 2
        }
        //primeList.forEachIndexed{ idx, value -> when{ idx % 2 == 0 -> {println("${idx}: ${value}")} }}
        //primeList.forEachIndexed{ idx, value -> println("${idx}: ${value}") }
        this.ans = primeList.filter { it }.size.toLong()
    }

    fun getAns(): Long {
        return this.ans
    }
}