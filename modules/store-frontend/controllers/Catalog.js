var restler = require('restler');

exports.catalog = function(a){
      return restler.get("http://localhost:8081/api/catalog").on('complete', function(data) {
          console.log(data.content);
          return data.content;
       });
 };
