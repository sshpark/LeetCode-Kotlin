open class Person {
    private var name: String
    private var status: Boolean

    constructor() {
        name = ""
        status = false
    }
}

class User : Person() {
    private var password: String = "121212"
}

fun main(args: Array<String>) {
    var a: Int, b: Int
    val list: MutableList<Person> = mutableListOf()
    list.add(User())
    println(list.size)
}