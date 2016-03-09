layout 'layout.tpl', title: 'Products : View all',
        content: contents {
            div(class: 'container') {
                div(class: 'pull-right') {
                    a(href: '/store?form', 'Create Product')
                }
                table(class: 'table table-bordered table-striped') {
                    thead {
                        tr {
                            td 'name'
                            td 'description'
                            td 'category'
                            td 'price'
                            td 'stock'
                        }
                    }
                    tbody {
                        if (products.empty) {
                            tr { td(colspan: '6', 'No products') }
                        }
                        products.each { product ->
                            tr {
                                td {
                                    a(href: "/store/${product.id}") {
                                        yield product.name
                                    }
                                }
                                td "${product.description}"
                                td "${product.category.name}"
                                td "${product.price}"
                                td "${product.stock}"
                            }
                        }
                    }
                }
            }
        }
