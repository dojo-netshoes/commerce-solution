layout 'layout.tpl', title: 'Products : Create',
        content: contents {
            form(class: 'form-horizontal', id: 'productForm', action: '/store', method: 'post') {
                if (formErrors) {
                    div(class: 'alert alert-error') {
                        formErrors.each { error ->
                            p error.defaultMessage
                        }
                    }
                }
                fieldset {
                    legend('Produtos')
                    div(class: 'form-group') {
                        label(for: 'name', 'Nome')
                        div(class: 'col-md-12') {
                            input(name: 'name', type: 'text', value: product.name ?: '',
                                    class: fieldErrors?.name ? 'form-control input-md field-error ' : 'form-control input-md',
                                    id: 'name', placeholder: 'Nome')
                            span(class: 'help-block', 'Nome do Produto')
                        }
                    }
                    div(class: 'form-group') {
                        label(for: 'description', 'Descrição')
                        div(class: 'col-md-12') {
                            input(name: 'description', type: 'text', value: product.description ?: '',
                                    class: fieldErrors?.description ? 'form-control input-md field-error ' : 'form-control input-md',
                                    id: 'description', placeholder: 'Descrição')
                            span(class: 'help-block', 'Descrição do Produto')
                        }
                    }
                    div(class: 'form-group') {
                        label(for: 'category', 'Categoria')
                        div(class: 'col-md-12') {
                            input(name: 'category', type: 'hidden', value: product?.category?.id ?: '')
                            input(name: 'category', type: 'text', value: product?.category?.name ?: '',
                                    class: fieldErrors?.product?.category?.name ? 'form-control input-md field-error ' : 'form-control input-md',
                                    id: 'category', placeholder: 'Categoria')
                            span(class: 'help-block', 'Categoria do Produto')
                        }
                    }
                    div(class: 'form-group') {
                        label(for: 'price', 'Preço')
                        div(class: 'col-md-12') {
                            input(name: 'price', type: 'text', value: product.price ?: '',
                                    class: fieldErrors?.price ? 'form-control input-md field-error ' : 'form-control input-md',
                                    id: 'price', placeholder: 'Preço')
                            span(class: 'help-block', 'Preço do Produto')
                        }
                    }
                    div(class: 'form-group') {
                        label(for: 'stock', 'Estoque')
                        div(class: 'col-md-12') {
                            input(name: 'stock', type: 'text', value: product.stock ?: '',
                                    class: fieldErrors?.stock ? 'form-control input-md field-error ' : 'form-control input-md',
                                    id: 'stock', placeholder: 'Estoque')
                            span(class: 'help-block', 'Estoque do Produto')
                        }
                    }
                    div(class: 'form-group') {
                        div(class: 'col-md-4') {
                            input(id: 'save', type: 'submit', class: 'btn btn-primary', value: 'Salvar')
                        }
                    }
                }
            }

        }
