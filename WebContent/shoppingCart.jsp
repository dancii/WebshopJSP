
<%@page import="com.webshop.bo.CartItem" %>
<%@page import="com.webshop.bo.ShoppingCart" %>
<%@page import="java.util.*" %>

<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Webshop</title>

    <!-- Bootstrap Core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="css/shop-homepage.css" rel="stylesheet">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>

    <!-- Navigation -->
    <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
        <div class="container">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="index.jsp">Webshop</a>
            </div>
            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">
                <%if(session.getAttribute("username")==null || session.getAttribute("username")==""){ %>
                	<li>
                		<a href="login.jsp">Login</a>
                	</li>
                <%}else{ %>
                	<li>
                		<a href="logout.jsp">Logout</a>
                <%} %>
                	</li>
                    <li>
                        <a href="#">About</a>
                    </li>
                    <li>
                        <a href="#">Services</a>
                    </li>
                    <li>
                        <a href="shoppingCart.jsp">Shopping cart(<%= ShoppingCart.countItem() %>)</a>
                    </li>
                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container -->
    </nav>

    <!-- Page Content -->
    <div class="container">

        <div class="row">
            <div class="col-md-9">

                <div class="row carousel-holder">

                    <div class="col-md-12">
                        <h1>WELCOME TO OUR WEBSHOP</h1>
                    </div>

					<div class="col-md-9">
		           Search items by name
		            	<form action="MainServlet" method="POST">
		                 	<input type="text" name="search" >
		                 	<input type="submit" name="searchBtn" value="Search">
							<input type="hidden" name="checkFunc" value="searchItemByName">
		                </form>
					</div>
                </div>
				<%
					if(session.getAttribute("shoppingCart")==null){
				%>
                <div class="row">
				
							<h5>Shopping cart is empty</h5>
						<%
					}else{
						
						ArrayList<CartItem> cartItems=(ArrayList<CartItem>) session.getAttribute("shoppingCart");
	                	Iterator iter=cartItems.iterator();
	                	int i=0;
	                	while(iter.hasNext()){
	                		CartItem ct=(CartItem) iter.next();
						%>
						
		                    <div class="col-sm-4 col-lg-4 col-md-4">
		                        <div class="thumbnail">
		                            <div class="caption">
		                                <h4 class="pull-right"><%= ct.getItemPrice() %> &ETH</h4>
		                                <h4><a href="#"><%= ct.getItemName() %></a>
		                                </h4>
		                                <form action="MainServlet" method="POST">
		                                	<input type="submit" name="remove" value="Remove">
		                                	<input type="hidden" name="itemIdRemove" value="<%= i %>">
		                                	<input type="hidden" name="checkFunc" value="removeItemCart">
		                            	</form>
		                            </div>
		                            
		                        </div>
		                    </div>
	          

                </div>
         		 <% 
         		 i++;
	                    } 
                    }
                    %>
            </div>
            <% if(session.getAttribute("username")!=null && ShoppingCart.countItem()>0){%>
            	
            
			<div class="col-md-9">
				<form action="">
					<input type="submit" name="checkout" value="Checkout">
				</form>
			</div>
            <%}else if(session.getAttribute("username")!=null && ShoppingCart.countItem()<=0 || session.getAttribute("username")==null && ShoppingCart.countItem()<=0){%>
            	
            <%}else{%>
            	<h5>Please sign in to check out</h5>
            <%} %>
        </div>

    </div>
    <!-- /.container -->

    <div class="container">

        <hr>

        <!-- Footer -->
        <footer>
            <div class="row">
                <div class="col-lg-12">
                    <p>Copyright &copy; Your Website 2014</p>
                </div>
            </div>
        </footer>

    </div>
    <!-- /.container -->

    <!-- jQuery Version 1.11.0 -->
    <script src="js/jquery-1.11.0.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="js/bootstrap.min.js"></script>

</body>

</html>
