var express = require('express');
var app = express();
var fs = require("fs");
var returnResponse = returnResponse;

app.get('/shoes', function(req, res) {
  var json = "/shoes/all";
  if (req.query.page) {
    json = json + "_page" + req.query.page;
  }
  fs.readFile(__dirname + json + ".json", 'UTF-8', function(err, data) {
    console.log(data);
    res.header("Content-Type", "application/json; charset=utf-8");
    res.send(JSON.parse(data));
    //res.end(data);
    //res.send(JSON.stringify({ a: 1 }));
  });
});

app.get('/banners/all', function(req, res) {
  var json = "/banners/all";
  if (req.query.page) {
    json = json + "_page" + req.query.page;
  }
  fs.readFile(__dirname + json + ".json", 'UTF-8', function(err, data) {
    console.log(data);
    res.header("Content-Type", "application/json; charset=utf-8");
    res.send(JSON.parse(data));
    //res.end(data);
    //res.send(JSON.stringify({ a: 1 }));
  });
});

app.get('/shoes/:id', function(req, res) {
  fs.readFile(__dirname + "/shoes/" + req.params.id + ".json", 'UTF-8', function(err, data) {
    console.log(data);
    res.header("Content-Type", "application/json; charset=utf-8");
    res.send(JSON.parse(data));
  });
});

app.get('/carousel', function(req, res) {
  fs.readFile(__dirname + "/carousel/all.json", 'UTF-8', function(err, data) {
    console.log(data);
    res.header("Content-Type", "application/json; charset=utf-8");
    res.send(JSON.parse(data));
  });
});

var returnResponse = function(res, data) {
  res.header("Content-Type", "application/json; charset=utf-8");
  res.send(JSON.parse(data));
}

  var server = app.listen(5000, function() {
  var host = server.address().address;
  var port = server.address().port;

  console.log("Example app listening at http://%s:%s", host, port);

});
