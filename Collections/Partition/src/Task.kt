// Return customers who have more undelivered orders than delivered
fun Shop.getCustomersWithMoreUndeliveredOrders(): Set<Customer> =
        this.customers.filter {
            val (delivered, notDelivered) = it.orders.partition(Order::isDelivered)
            return@filter notDelivered.size > delivered.size
        }.toSet()
