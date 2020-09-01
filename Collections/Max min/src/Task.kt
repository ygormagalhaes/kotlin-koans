// Return a customer who has placed the maximum amount of orders
fun Shop.getCustomerWithMaxOrders(): Customer? =
        this.customers.maxBy { it.orders.size }

// Return the most expensive product that has been ordered by the given customer
fun getMostExpensiveProductBy(customer: Customer): Product? =
        customer.orders
                .flatMap(Order::products)
                .maxBy(Product::price)

        /* Original solution
        customer.orders
                .mapNotNull { it.products.maxBy { p -> p.price } }
                .maxBy { it.price }
         */
