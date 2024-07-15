class Book{
    var title: String = ""
    var author: String = ""
    var isbn: String = ""
}

var books = Array[Book]()

def addBook(): Unit = {
    var book = new Book()
    print("Enter Title: ")
    book.title = scala.io.StdIn.readLine()
    print("Enter Author: ")
    book.author = scala.io.StdIn.readLine()
    print("Enter ISBN: ")
    book.isbn = scala.io.StdIn.readLine()
    println()
    books = books :+ book
}

def removeBook(isbn: String): Unit = {
    var index = books.indexWhere(_.isbn == isbn)
    if (index != -1) {
        books = books.filter(_.isbn != isbn)
    } else {
        println("Book not found")
    }
}

def displayBooks(): Unit = {
    println("Title\t\t\tAuthor\t\t\tISBN")
    for (i<-0 until books.length) {
        println(books(i).title + "\t\t" + books(i).author + "\t\t" + books(i).isbn)
    }
}

def checkBook(isbn: String): Unit = {
    var index = books.indexWhere(_.isbn == isbn)
    if (index != -1) {
        println("Book exists")
        println("Title: " + books(index).title)
        println("Author: " + books(index).author)
        println("ISBN: " + books(index).isbn)
    }
    else{
        print("Book does not exist")
    }
}

def searchBook(name: String): Unit = {
    var index = books.indexWhere(_.title == name)
    if (index != -1) {
        println("Title\t\t\tAuthor\t\t\tISBN")
        println(books(index).title + "\t\t" + books(index).author + "\t\t" + books(index).isbn)
    } else {
        println("Book not found")
    }
}

def displayBookByAuthor(name: String): Unit = {
    var booksByAuthor = books.filter(_.author == name)
    if (booksByAuthor.length != 0) {
        println("Title\t\t\tAuthor\t\t\tISBN")
        for (i<-0 until booksByAuthor.length) {
            println(booksByAuthor(i).title + "\t\t" + booksByAuthor(i).author + "\t\t" + booksByAuthor(i).isbn)
        }
    } else {
        println("Book not found")
    }
}

@main def Q2() : Unit = {
    println("***********Welcome to the Library Management System*********")
    var continue = true
    while(continue){
        println("Enter 1 to display books")
        println("Enter 2 to add book")
        println("Enter 3 to remove book")
        println("Enter 4 to check book")
        println("Enter 5 to search book")
        println("Enter 6 to display book by author")
        println("Enter 7 to exit")
        print("Enter your choice: ")
        var choice = scala.io.StdIn.readInt()
        println() 
        choice match {
            case 1 => displayBooks()
            case 2 => addBook()
            case 3 => {
                print("Enter ISBN: ")
                var isbn = scala.io.StdIn.readLine()
                removeBook(isbn)
            }
            case 4 => {
                print("Enter ISBN: ")
                var isbn = scala.io.StdIn.readLine()
                checkBook(isbn)
            }
            case 5 => {
                print("Enter Title: ")
                var title = scala.io.StdIn.readLine()
                searchBook(title)
            }
            case 6 => {
                print("Enter Author: ")
                var author = scala.io.StdIn.readLine()
                displayBookByAuthor(author)
            }
            case 7 => continue = false
            case _ => println("Invalid choice")
        }
        println()
    }
    println("Exiting...");
}