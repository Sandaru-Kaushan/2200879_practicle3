import scala.io.StdIn.readLine

object InventoryManagementSystem {

  def main(args: Array[String]): Unit = {
    val products = getProductList()
    printProductList(products)
    println(s"Total number of products: ${getTotalProducts(products)}")
  }

  def getProductList(): List[String] = {
    var productList: List[String] = List()
    var input: String = ""

    println("Enter product names. Type 'done' to finish:")

    input = readLine()
    while (input.toLowerCase != "done") {
      productList = productList :+ input
      input = readLine()
    }

    productList
  }

  def printProductList(products: List[String]): Unit = {
    products.zipWithIndex.foreach { case (product, index) =>
      println(s"${index + 1}. $product")
    }
  }

  def getTotalProducts(products: List[String]): Int = {
    products.length
  }
}
