fun cool() : String {
    return "Kotlin is an interesting language";
}

fun dataStructures() : Int {
    var fruitCount = 0;
    val fruits = listOf<String>("apple", "pear", "orange");
    for (fruit in fruits) {
        fruitCount++;
    }

    return fruitCount;
}

fun main() {
    val name = "Kasim";
    println("Hello, $name, ${cool()}");
    println("There are ${dataStructures()} fruits.")
}