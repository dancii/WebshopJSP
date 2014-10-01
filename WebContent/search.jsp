
<%@page import="com.webshop.bo.ItemInfo" %>
<%@page import="java.util.*" %>
<%@page import="com.webshop.bo.Category" %>
<%@page import="com.webshop.bo.CategoryHandler" %>
<%@page import="com.webshop.bo.ShoppingCart" %>

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
                        <a href="shoppingCart.jsp">Chopping cart(<%= ShoppingCart.countItem() %>)</a>
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

            <div class="col-md-3">
                <p class="lead">Categories</p>
                <div class="list-group">
                  <%ArrayList<Category> categories= CategoryHandler.getAllCategories();
					Iterator<Category> iter2 = categories.iterator();

					while(iter2.hasNext()){
						Category t = iter2.next();
						
					%>
						<div class="list-group-item">
						<form action="MainServlet" method="POST">
								Search by <input type="submit" name="searchItemByCategory" value="<%= t.getCategory() %>">
								<input type="hidden" name="itemId" value="<%= t.getId() %>">
								<input type="hidden" name="itemName" value="<%= t.getCategory() %>">
								<input type="hidden" name="checkFunc" value="findItemsByCategory">
						</form>
						</div>
					<%
					}
					%>
				</div>
			</div>
            <div class="col-md-4">
            	<form action="MainServlet" method="POST">
                 	<input type="text" name="search" >
                 	<input type="submit" name="searchBtn" value="Search">
					<input type="hidden" name="checkFunc" value="searchItemByName">
                </form>
			</div>
            <div class="col-md-9">

                <div class="row carousel-holder">

                    <div class="col-md-12">
                        <h1>Search results</h1>
                    </div>

                </div>

                <div class="row">
					<%
					if(request.getAttribute("itemsList")==null){
						%>
							<h5>Search result came back empty meanwhile...</h5>
							<h7 style="font-color: red">How much wood would a woodchuck chuck if a woodchuck could chuck wood?</h7>
						<%
					}else{
						ArrayList<ItemInfo> items= (ArrayList<ItemInfo>) request.getAttribute("itemsList");
						System.out.println("supzzz: " + items.size());
						Iterator iter = items.iterator();
						int i = 0;
							while(iter.hasNext()){
								ItemInfo t = (ItemInfo) iter.next();
								System.out.println("Supz: " + i);
						%>
		                    <div class="col-sm-4 col-lg-4 col-md-4">
		                        <div class="thumbnail">
		                            <div class="caption">
		                                <h4 class="pull-right"><%= t.getPrice() %> &ETH</h4>
		                                <h4><a href="#"><%= t.getName() %></a>
		                                </h4>
		                                <p><%= t.getDescription() %></p>
		                                <form action="MainServlet" method="POST">
		                                	<input type="submit" name="buy" value="BUY">
		                                	<input type="hidden" name="itemId" value="<%= t.getId() %>">
		                                	<input type="hidden" name="itemName" value="<%= t.getName() %>">
		                                	<input type="hidden" name="itemPrice" value="<%= t.getPrice() %>">
		                                	<input type="hidden" name="checkFunc" value="buyItemById">
		                            	</form>
		                            </div>
		                            
		                        </div>
		                    </div>
	                    <% 
	                    i++;
	                    } 
                    }
                    %>

                </div>

            </div>

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
