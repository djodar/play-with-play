package models

/**
 * Created by daniel.jodar on 19/06/2015.
 */
case class Product (ean: Long, name: String, description: String)

object Product {

  var products = Set (
    Product(654654546L, "Paperclips Large", "Large plaing pacj of 1000"),
    Product(654324546L, "Paperclips Giant", "Giant plaing of 10")
  )

  def findAll = products.toList.sortBy(_.ean)

}
