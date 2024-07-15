case class Book(title: String, author: String, isbn: String)

object Library {

  var books: Set[Book] = Set(
    Book("1925", "Imesh Madushanka Yapa", "1234567890"),
    Book("Hound of Baskervilles", "Arthur Conan Doyle", "2345678901"),
    Book("Da vinci code", "Dan Brown", "3456789012")
  )

  def addBook(book: Book): Unit = {
    books += book
    println(s"Book '${book.title}' added to the library.")
  }

  def removeBook(isbn: String): Unit = {
    books.find(_.isbn == isbn) match {
      case Some(book) =>
        books -= book
        println(s"Book '${book.title}' removed from the library.")
      case None =>
        println(s"No book found with ISBN: $isbn")
    }
  }

  def isBookInLibrary(isbn: String): Boolean = {
    books.exists(_.isbn == isbn)
  }

  def displayLibrary(): Unit = {
    println("Current library collection:")
    books.foreach(book => println(s"Title: ${book.title}, Author: ${book.author}, ISBN: ${book.isbn}"))
  }

  def searchByTitle(title: String): Unit = {
    books.find(_.title.equalsIgnoreCase(title)) match {
      case Some(book) =>
        println(s"Book found - Title: ${book.title}, Author: ${book.author}, ISBN: ${book.isbn}")
      case None =>
        println(s"No book found with title: $title")
    }
  }

  def displayBooksByAuthor(author: String): Unit = {
    val booksByAuthor = books.filter(_.author.equalsIgnoreCase(author))
    if (booksByAuthor.nonEmpty) {
      println(s"Books by $author:")
      booksByAuthor.foreach(book => println(s"Title: ${book.title}, ISBN: ${book.isbn}"))
    } else {
      println(s"No books found by author: $author")
    }
  }

  def main(args: Array[String]): Unit = {
    displayLibrary()

    val newBook = Book("Sign of the Four", "Arthur Conan Doyle", "4567890123")
    addBook(newBook)
    displayLibrary()

    removeBook("2345678901")
    displayLibrary()

    println(s"Is '1925' in the library? ${isBookInLibrary("1234567890")}")
    println(s"Is 'Hound of Baskervilles' in the library? ${isBookInLibrary("2345678901")}")

    searchByTitle("Sign of the Four")
    searchByTitle("True Love Story")

    displayBooksByAuthor("Dan Brown")
    displayBooksByAuthor("J.K. Rowling")
  }
}
