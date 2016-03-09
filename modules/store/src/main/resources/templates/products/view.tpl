layout 'layout.tpl', title: 'Products : View',
        content: contents {
            div(class: 'container') {
                if (globalMessage) {
                    div(class: 'alert alert-success', globalMessage)
                }
                div(class: 'pull-right') {
                    a(href: '/store', 'Products')
                }
                dl {
                    dt 'ID'
                    dd(id: 'id', product.id)
                    dt 'Name'
                    dd(id: 'name', "${product.name}")
                    dt 'Description'
                    dd(id: 'description', product.description)
                    dt 'Category'
                    dd(id: 'category', product.category.name)
                    dt 'Price'
                    dd(id: 'price', product.price)
                    dt 'stock'
                    dd(id: 'stock', product.stock)
                }
            }
        }
