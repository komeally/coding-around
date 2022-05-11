import java.util.Scanner

fun main() {
    val reader = Scanner(System.`in`)

    print("Enter your name: ")
    val name = reader.nextLine()

    print("How old are you?: ")
    val age = reader.nextInt();


    println("Hello $name, you are $age years old.")

    reader.close();
}