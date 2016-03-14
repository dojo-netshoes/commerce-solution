var express = require('express');
var views = require('dot').process({path: "./views"});
var dot = require('dot');
var path = require('path');
var bodyParser = require('body-parser');
var url = require('url');
var restler = require('restler');

var app = express();
var port = process.env.PORT || 3000;

/* express configuration */
app.use(bodyParser.json());
app.use(bodyParser.urlencoded({ extended: true }));

app.use(express.static(path.join(__dirname, 'public')));

/* actions */
// res.status(200).send(render());
app.get("/", function(req, res) {
   var render = require('./views/home');
   restler.get("http://localhost:8081/api/catalog").on('complete', function(data) {
          console.log(data);
          res.status(200).send(render(data));
   });

});



//app.get("/list", function(req, res) {
//  var url_parts = url.parse(req.url, true);
//  var data = url_parts.query;
//
//  var page = parseInt(data.page) || 1;
//
//  rest.get(MOCK+'/shoes/all_page' + page).on('complete', function(data) {
//    var render = require('./views/list');
//    res.status(200).send(render({page: page, products: data.content}));
//  });
//
//});
//
//app.post('/api/templates', function(req, res) {
//  var template = req.body;
//  var db = req.db;
//  var collection = db.get('templates');
//
//  // saving in mongo
//  collection.remove({key: template.key});
//  collection.insert(template, function(err, doc){
//    if(err) { console.log(err); }
//    else {console.log('saving template: ' + template.key);}
//  });
//
//
//  res.status(200).send('ok');
//});
//
//app.post('/api/partials', function(req, res) {
//  var partial = req.body;
//  var db = req.db;
//  var collection = db.get('partials');
//
//  // saving in mongo
//  collection.remove({key: partial.key});
//  collection.insert(partial, function(err, doc){
//    if(err) { console.log(err); }
//    else {console.log('saving partial: ' + partial.key);}
//  });
//
//
//  res.status(200).send('ok');
//});
//
//app.get("/templates", function(req,res){
//  var db = req.db;
//
//  db.get('templates').find({}, {}, function(err, templates){
//    if(err) {
//      console.log(err);
//      res.status(500);
//    } else {
//      res.status(200).send(views.templates({templates: templates}))
//    }
//
//  });
//
//});
//
//
//app.get('/partials/:partial', function(req, res){
//  var db = req.db;
//  var key = req.params.partial;
//
//  db.get('partials').find({key: key}, {}, function(err, partials){
//    if (!err && partials[0]) {
//      var partial = partials[0];
//      res.status(200).send(partial);
//    } else {
//      res.status(404).send(result);
//    }
//  });
//});

app.listen(port);
console.log('starting server - listening port 3000');
