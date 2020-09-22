fun renderProductTable(): String {
    return html {
        table {
            tr(getTitleColor()) {
                td {
                    text("Product")
                }
                td {
                    text("Price")
                }
                td {
                    text("Popularity")
                }
            }

            for ((rowIndex, product) in getProducts().withIndex()) {
                tr {
                    td(getCellColor(1, rowIndex)) {
                        text(product.description)
                    }
                    td(getCellColor(2, rowIndex)) {
                        text(product.price)
                    }
                    td(getCellColor(3, rowIndex)) {
                        text(product.popularity)
                    }
                }
            }

        }
    }.toString()
}

fun getTitleColor() = "#b9c9fe"
fun getCellColor(index: Int, row: Int) = if ((index + row) % 2 == 0) "#dce4ff" else "#eff2ff"
