var express = require('express');
var app = express();
var views = require('dot').process({path: "./views"});
var bodyParser = require('body-parser');
var port = process.env.PORT || 3000

app.set('views', __dirname + '/views')
app.engine('dot', require('dot').__express)
app.set('view engine', 'dot')

app.use(express.static(__dirname + '/public'))
app.use(bodyParser.json())
app.use(bodyParser.urlencoded({extended: true}))
app.use(require('./controllers'))

app.listen(port, function() {
  console.log('Listening on port ' + port)
})
