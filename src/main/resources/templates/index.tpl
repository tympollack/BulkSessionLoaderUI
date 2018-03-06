yieldUnescaped '<!DOCTYPE html>'
html(lang: 'en') {
    head {
        script(type: 'text/javascript', src: 'js/jquery.min.js') {}
        script(type: 'text/javascript', src: 'js/bootstrap.min.js') {}
        script(type: 'text/javascript', src: 'js/index.js') {}
        title('Historical Session Validator')
        link(rel: 'stylesheet', href: 'style/bootstrap.min.css')
        link(rel: 'stylesheet', href: 'style/main.css')
    }
    body {
        div(class: 'wrapper') {
            div(class: 'form') {
                div(id: 'errors'){}
                div(class: 'container') {
                    h1('Historical Session Validator')
                    details.each { detail ->
                        div(class: 'input-group') {
                            span(class: 'input-group-addon', detail.desc)
                            input(type: 'text', id:detail.key, class: 'form-control', detail.default)
                        }
                    }
                    button(type: "submit", onclick: "submitJob()", class:'btn btn-success', "Create Job")
                }
            }
        }
    }
}