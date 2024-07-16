import scala.io.StdIn.readLine
import scala.io.StdIn.readInt

case class Book(title: String, author: String, isbn: String)

var books: Set[Book] = Set()

def addBook(): Unit = {
  print("Enter Title: ")
  val title = readLine()
  print("Enter Author: ")
  val author = readLine()
  print("Enter ISBN: ")
  val isbn = readLine()
  println()
  val book = Book(title, author, isbn)
  books += book
}

def removeBook(isbn: String): Unit = {
  val initialSize = books.size
  books = books.filterNot(_.isbn == isbn)
  if (initialSize == books.size) {
    println("Book not found")
  }
}

def displayBooks(): Unit = {
  println("Title\t\t\tAuthor\t\t\tISBN")
  books.foreach(book => println(s"${book.title}\t\t${book.author}\t\t${book.isbn}"))
}

def checkBook(isbn: String): Unit = {
  books.find(_.isbn == isbn) match {
    case Some(book) =>
      println("Book exists")
      println(s"Title: ${book.title}")
      println(s"Author: ${book.author}")
      println(s"ISBN: ${book.isbn}")
    case None => println("Book does not exist")
  }
}

def searchBook(name: String): Unit = {
  books.find(_.title.equalsIgnoreCase(name)) match {
    case Some(book) =>
      println("Title\t\t\tAuthor\t\t\tISBN")
      println(s"${book.title}\t\t${book.author}\t\t${book.isbn}")
    case None => println("Book not found")
  }
}

def displayBookByAuthor(name: String): Unit = {
  val booksByAuthor = books.filter(_.author.equalsIgnoreCase(name))
  if (booksByAuthor.nonEmpty) {
    println("Title\t\t\tAuthor\t\t\tISBN")
    booksByAuthor.foreach(book => println(s"${book.title}\t\t${book.author}\t\t${book.isbn}"))
  } else {
    println("Book not found")
  }
}

@main def Q2(): Unit = {
  println("***********Welcome to the Library Management System*********")
  var continue = true
  while (continue) {
    println("Enter 1 to display books")
    println("Enter 2 to add book")
    println("Enter 3 to remove book")
    println("Enter 4 to check book")
    println("Enter 5 to search book")
    println("Enter 6 to display book by author")
    println("Enter 7 to exit")
    print("Enter your choice: ")
    val choice = readInt()
    println()
    choice match {
      case 1 => displayBooks()
      case 2 => addBook()
      case 3 =>
        print("Enter ISBN: ")
        val isbn = readLine()
        removeBook(isbn)
      case 4 =>
        print("Enter ISBN: ")
        val isbn = readLine()
        checkBook(isbn)
      case 5 =>
        print("Enter Title: ")
        val title = readLine()
        searchBook(title)
      case 6 =>
        print("Enter Author: ")
        val author = readLine()
        displayBookByAuthor(author)
      case 7 => continue = false
      case _ => println("Invalid choice")
    }
    println()
  }
  println("Exiting...")
}
