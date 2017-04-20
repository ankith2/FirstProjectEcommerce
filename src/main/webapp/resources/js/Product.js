$(document).ready(function(){
	 var path="/menswear/resources/images/";
  $("#productstable").DataTable({
	
	  "ajax": {
		    "url": "http://localhost:8083/menswear/admin/adminproducts/all",
		    "dataSrc": ""
		  },
	  "columns": [
          { "data": "productName" },
          { "data": "",
        	"render":function(data,type,row)
        	{
        	  return "&#8360;."+row.productPrice+"";
          }  
          
          },
          { "data":"quantity" },
          
          {data:"productName",
        	  mRender:function(data,type,row){
        		  return '<img src="'+path+data+'.jpg" width="25px" height="25px"></img>';
        	  }
          },
          
          {"data":"productId",
        	  "render":function(data,type,row){
        		  return "<a href='http://localhost:8083/menswear/admin/"+row.productId+"/editproduct' class='btn btn-primary'>Edit</a>";
        	  }
          },
        	
         {"data":"",
        	  "render":function(data,type,row){
        		  return "<a href='http://localhost:8083/menswear/admin/"+row.productId+"/deleteproduct' class='btn btn-primary'>Delete</a>";
        	  }
          }  
                    
      ]
  });
    
    
});
