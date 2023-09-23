package com.example.b3sync.kotlinexs

fun main() {
    val result = double(2)
    println(result)
    var namesList = asList("abdul", "ansari", "tanveer")
    println(namesList)
    val list = mutableListOf(1, 2, 3)
    println("before exchange $list")
    list.exchange(0, 2)
    println("after exchange $list")

}


fun MutableList<Int>.exchange(index1: Int, index2: Int) {
    val tmp = this[index1] // 'this' corresponds to the list
    this[index1] = this[index2]
    this[index2] = tmp
}

fun add(a: Int, b: Int) {
    var c = a + b //c = local variable
    c = 10
}

fun calculate() {
    add(10, 20)
}

fun double(x: Int) = 2 * x

fun <T> asList(vararg ts: T): List<T> {
    val result = ArrayList<T>()
    for (t in ts) // ts is an Array
        result.add(t)

    return result
}

/*fun <T> add(a: T, b:T):T{
 return  a + b
}*/


/*
fun main() {
  3 hypoteneuse 4
  printMessage("my  message is")//caller
  printMessageWithPrefix(prefix = "$$$", message = "your money")
}

fun printMessage(message: String): Unit {   //callee                            // 1
  println(message)
}

fun printMessageWithPrefix(message: String, prefix: String = "Info") {  // 2
  println("[$prefix] $message")
}

infix fun Int.hypoteneuse(breadth:Int){
  var result = this * this + (breadth * breadth)
  println("the hypoteneuse is = $result")
}*/
