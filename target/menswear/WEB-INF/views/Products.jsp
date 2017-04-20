<%@include file="Header.jsp"%>

<script>

$(document).ready(function(){
	 var path="http://localhost:8083/menswear/resources/images/";
	 var id=${id};
 $("#productstable").DataTable({
	
	  "ajax": {
		    "url": "http://localhost:8083/menswear/"+id+"/catproducts",
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
       		  return "<a href='http://localhost:8083/menswear/"+row.productId+"/viewproduct' class='btn btn-primary'>View</a>";
       	  }
         },
       	
        {"data":"",
       	  "render":function(data,type,row){
       		  return "<a href='http://localhost:8083/menswear/customer/"+row.productId+"/addcart' class='btn btn-primary'>Add to cart</a>";
       	  }
         }  
                   
     ]
 });
   
   
});
</script>
<%-- <script type="text/javascript" src="${js}/allprod.js"></script> --%>

<div class="container-fluid">
	<div class="row">
		<div class="col-sm-1"></div>
		<div class="col-sm-10">
			<table class="table table-hover" id="productstable">
				<thead>
					<tr>
						<th>Product Name</th>
						<th>Product Price </th>
						<th>Quantity</th>
						<th></th>
						<th></th>
						<th></th>
						
					</tr>
				</thead>
							</table>
		</div>
		
	</div>
</div>

<%@include file="Footer.jsp"%>