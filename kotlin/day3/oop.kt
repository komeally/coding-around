class Person(fname: String, age: Int) {
    private val firstName: String
    val age: Int

    init{
        this.firstName = fname
        this.age = age
    }

    fun getFirstName() : String {
        return firstName;
    }
}

fun main() {
    val me = Person("Kasim", 18)
    println("I'm ${me.getFirstName()} and I am ${me.age} years old.")
}