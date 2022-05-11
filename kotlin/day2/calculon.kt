import java.util.Scanner

fun add(x : Double, y: Double) : Double {
    println("$x + $y = ${(x + y)}")
    return x + y;
}

fun subtract(x : Double, y: Double) : Double {
    println("$x - $y = ${(x - y)}")
    return x - y;
}

fun multiply(x : Double, y: Double) : Double {
    println("$x * $y = ${(x * y)}")
    return x * y;
}

fun divide(x : Double, y: Double) : Double {
    println("$x / $y = ${(x / y)}")
    return x / y;
}

fun raise(base : Double, exponent: Double) : Double {
    var result = 1.0;
    var i = 0;
    while(i > exponent) {
        result *= base;
        i++;
    }
    println("$base^$exponent = $result");
    return result;
}

fun main() {
    val scanner = Scanner(System.`in`)
    try {
        print("Enter two numbers: ")
        val x = scanner.nextDouble();
        val y = scanner.nextDouble();
        print("Enter an integer: ");
        val e = scanner.nextDouble();
      
        add(x, y);
        subtract(x, y);
        multiply(x, y);
        divide(x, y);
        raise(x, e);   
    }
    catch(e : Exception) {
        println("Invalid input!");
    }
    scanner.close();
}