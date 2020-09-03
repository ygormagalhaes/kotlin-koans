// Return the set of products that were ordered by all customers
fun Shop.getProductsOrderedByAll(): Set<Product> {
    val allProducts = customers
            .flatMap(Customer::getOrderedProducts)
            .toSet()

    return customers.fold(allProducts, {
        orderedByAll, customer -> orderedByAll.intersect(customer.getOrderedProducts())
    })
}


fun Customer.getOrderedProducts(): List<Product> =
        this.orders.flatMap { it.products }
