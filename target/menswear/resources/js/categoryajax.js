$(document).ready(function(){
	
  $("#categorytable").DataTable({
	
	  "ajax": {
		    "url": "http://localhost:8083/menswear/admin/categories/all",
		    "dataSrc": ""
		  },
	  "columns": [
		
		  { "data": "categoryName" },
          {"data":null,
        	  "render":function(data,type,row){
        		  return "<a href='http://localhost:8083/menswear/admin/"+row.id+"/editcategory' class='btn btn-primary'>Edit</a>";
        	  }
          },
          
          {"data":null,
        	  "render":function(data,type,row){
        		  return "<a href='http://localhost:8083/menswear/admin/"+row.id+"/deletecategory' class='btn btn-primary'>Delete</a>";
        	  }
          }
                
      ]
  });
    
    
});
