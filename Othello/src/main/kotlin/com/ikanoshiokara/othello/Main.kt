package com.ikanoshiokara.othello

fun main(args: Array<String>){
    val console = System.console() ?: null
    var status: Int = 0
    var board: MutableList<String> = (0..9).map{"."}.toMutableList()

    while (true){
        (0..9).forEach { print("${it}") }
        println()
        (0..9).forEach{ print("${board[it]}") }
        println()

        when(status){
            0 -> {
                println("プレイヤー白が入力してください")
            }
            1 -> {
                println("プレイヤー黒が入力してください")
            }
        }

        print("> ")
        val input = console?.readLine() ?: readLine() ?: ""
        if(input.isBlank()) return

        if(board[input.toInt()] != "."){
            println("そのマスは埋まっています")
            continue
        }else{
            board = isReplaceBoard(board, input.toInt(), status)
            if(isCheckBattle(board)){
                (0..9).forEach { print("${it}") }
                println()
                (0..9).forEach{ print("${board[it]}") }
                println()
                var result = isResult(board)
                when(result[0]){
                    0 -> {
                        println("プレイヤー白が${result[1]}個で勝利")
                    }
                    1 -> {
                        println("プレイヤー黒が${result[1]}個で勝利")
                    }
                    else -> {
                        println("draw")
                    }
                }
                return
            }
            status = (status + 1) % 2
        }
    }
}

fun isReplaceBoard(board: MutableList<String>, input: Int, status: Int): MutableList<String>{
    var tmp: MutableList<String> = board

    when(status){
        0 -> {
            var index = 0
            when{
                input < 2 -> {
                    for (i in input..9){
                        if(input == i){
                            continue
                        }
                        if(board[i] == "b"){
                            index++
                        }else if(board[i] == "w"){
                            for(j in 0..index){
                                tmp[i - j - 1] = "w"
                            }
                            break
                        }else{
                            break
                        }
                    }
                }
                input >= 2 -> {
                    for (i in 0..input){
                        if(input == input - i){
                            continue
                        }
                        if(board[input - i] == "b"){
                            index++
                        }else if(board[input - i] == "w"){
                            for(j in 0..index){
                                tmp[input - j] = "w"
                            }
                            break
                        }else{
                            break
                        }
                    }
                    index = 0
                    for (i in input..9){
                        if(input == i){
                            continue
                        }
                        if(board[i] == "b"){
                            index++
                        }else if(board[i] == "w"){
                            for(j in 0..index){
                                tmp[i - j - 1] = "w"
                            }
                            break
                        }else{
                            break
                        }
                    }
                }
                input >= 8 -> {
                    for (i in 0..input){
                        if(input == input - i){
                            continue
                        }
                        if(board[input - i] == "b"){
                            index++
                        }else if(board[input - i] == "w"){
                            for(j in 0..index){
                                tmp[input - j] = "w"
                            }
                            break
                        }else{
                            break
                        }
                    }
                }
            }
            tmp[input] = "w"
        }
        1 -> {
            var index = 0
            when{
                input < 2 -> {
                    for (i in input..9){
                        if(input == i){
                            continue
                        }
                        if(board[i] == "w"){
                            index++
                        }else if(board[i] == "b"){
                            for(j in 0..index){
                                tmp[i - j - 1] = "b"
                            }
                            break
                        }else{
                            break
                        }
                    }
                }
                input >= 2 -> {
                    for (i in 0..input){
                        if(input == input - i){
                            continue
                        }
                        if(board[input - i] == "w"){
                            index++
                        }else if(board[input - i] == "b"){
                            for(j in 0..index){
                                tmp[input - j] = "b"
                            }
                            break
                        }else{
                            break
                        }
                    }
                    index = 0
                    for (i in input..9){
                        if(input == i){
                            continue
                        }
                        if(board[i] == "w"){
                            index++
                        }else if(board[i] == "b"){
                            for(j in 0..index){
                                tmp[i - j - 1] = "b"
                            }
                            break
                        }else{
                            break
                        }
                    }
                }
                input >= 8 -> {
                    for (i in 0..input){
                        if(input == input - i){
                            continue
                        }
                        if(board[input - i] == "w"){
                            index++
                        }else if(board[input - i] == "b"){
                            for(j in 0..index){
                                tmp[input - j] = "b"
                            }
                            break
                        }else{
                            break
                        }
                    }
                }
            }
            tmp[input] = "b"
        }
    }

    return tmp
}

fun isCheckBattle(board: MutableList<String>): Boolean{
    (0..9).forEach{if(board[it] == ".") return false}
    return true
}

fun isResult(board: MutableList<String>): List<Int>{
    var tmp: MutableList<Int> = mutableListOf()
    var white = 0
    var black = 0
    (0..9).forEach{
        when(board[it]) {
            "w" -> white++
            "b" -> black++
        }
    }
    if(white > black){
        tmp.add(0)
        tmp.add(white)
    }else if(white < black){
        tmp.add(1)
        tmp.add(black)
    }else{
        tmp.add(3)
        tmp.add(0)
    }
    return tmp
}