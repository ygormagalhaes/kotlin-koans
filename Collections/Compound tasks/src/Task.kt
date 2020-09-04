// Find the most expensive product among all the delivered products
// ordered by the customer. Use `Order.isDelivered` flag.
fun findMostExpensiveProductBy(customer: Customer): Product? =
        customer.orders
                .filter(Order::isDelivered)
                .flatMap(Order::products)
                .maxBy(Product::price)

// Count the amount of times a product was ordered.
// Note that a customer may order the same product several times.
fun Shop.getNumberOfTimesProductWasOrdered(product: Product): Int =
        customers.fold(0) { totalOrders, customer ->
            totalOrders + customer.getOrderedProducts().filter { it == product }.size
        }


fun Customer.getOrderedProducts(): List<Product> =
        orders.flatMap(Order::products)
