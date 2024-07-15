var productList = Array[String]();

def getProductList(list: Array[String]): Unit = {
  var continue = true
  var i=1
  println("Enter done to stop entering products")
  while(continue){
    print("Enter Name of Product " + i + " : ");
    var product = scala.io.StdIn.readLine()
    if(product == "done" || product == "Done"){
      continue = false
      println()
    } else {
      productList = productList :+ product
      i += 1
    }
  }
}

def printProductList(list: Array[String]): Unit = {
  println("Product List")
  println("------------")
  for (i<-0 until list.length) {
    println("Product "+ (i+1) + "-" + list(i))
  }
  println()
}

def getTotalProducts(list: Array[String]): Unit = {
  println("Total Products: " + list.length)
  println()
}

@main def main1(): Unit = {
  println("***********Welcome to the Inventory Management System*********")
  var continue = true
  while(continue){
    println("Enter 1 to enter product list")
    println("Enter 2 to print product list")
    println("Enter 3 to get total products")
    println("Enter 4 to exit")
    print("Enter your choice: ")
    var choice = scala.io.StdIn.readInt()
    println() 
    choice match {
      case 1 => getProductList(productList)
      case 2 => printProductList(productList)
      case 3 => getTotalProducts(productList)
      case 4 => continue = false
      case _ => println("Invalid choice")
    }
  }
}