def fibonacci(n: Int): Seq[Int] = {
    if (n <= 0) Seq()
    else if (n == 1) Seq(0)
    else if (n == 2) Seq(0, 1)
    else {
        var fibSeq = Seq(0, 1)
        for (i <- 2 until n) {
            fibSeq = fibSeq :+ (fibSeq(i-1) + fibSeq(i-2))
        }
        return fibSeq
    }  
}

@main def Q3() : Unit = {
    print("Enter the number of terms of Fibonacci series to display: ")
    val n = scala.io.StdIn.readInt()
    if(n <= 0) {
        println("Invalid input")
        return
    }
    val fibSeq = fibonacci(n)
    println(fibSeq.mkString(", "))
}
