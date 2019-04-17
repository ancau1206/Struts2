<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
   
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!-- Tell the browser to be responsive to screen width -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <!-- Favicon icon -->
    
    <title>Admin | An Cầu</title>
    <!-- Custom CSS -->
 
    <!-- Custom CSS -->
   
    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
<![endif]-->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
</head>

<body>
  <script type="text/javascript">
$(document).ready(function(){
    $(".delete").click(function(){
    	var name = $(this).parents().eq(2).find(".departName").eq(0).text();
    	var id = $(this).parents().eq(2).find(".departId").eq(0).val();
        var check = confirm("Bạn có muốn xóa phòng ban "+name+" này không");
        if (check) {
        	$(this).parents().eq(2).remove();
        	$.get('/Shop/deleteDeparts?id='+id);
        }
    });
});
</script>
    <div class="preloader">
        <div class="lds-ripple">
            <div class="lds-pos"></div>
            <div class="lds-pos"></div>
        </div>
    </div>
  
		<jsp:include page="../include/header.jsp" />
		<!-- aside -->
		<jsp:include page="../include/aside.jsp" />
  
    <div id="main-wrapper" data-navbarbg="skin6" data-theme="light" data-layout="vertical" data-sidebartype="full" data-boxed-layout="full">
        
        
     
        <div class="page-wrapper">
           
            <div class="page-breadcrumb">
                <div class="row">
                    <div class="col-5 align-self-center">
                        <h4 class="page-title">Phòng ban</h4>
                    </div>
                    <div class="col-7 align-self-center">
                        <div class="d-flex align-items-center justify-content-end">
                            <nav aria-label="breadcrumb">
                                <ol class="breadcrumb">
                                    <li class="breadcrumb-item">
                                        <a href="#">Home</a>
                                    </li>
                                    <li class="breadcrumb-item active" aria-current="page">Dashboard</li>
                                </ol>
                            </nav>
                        </div>
                    </div>
                </div>
            </div>
         
            <div class="container-fluid">
               
                <div class="row">
                    <div class="col-md-8">
                       
                    </div>
                    <div class="col-md-4">
                        
                        
                    </div>
                </div>
             
                <div class="row">
                    <!-- column -->
                    <div class="col-12">
                        <div class="card">
                            <div class="card-body">
                                <h4 class="card-title">Danh sách phòng ban</h4>
                            </div>
                            <div class="table-responsive">
                                <table class="table table-hover">
                                    <thead>
                                        <tr>
                                            <th class="border-top-0">Mã phòng ban</th>
                                            <th class="border-top-0">Tên phòng ban</th>
                                             <th class="border-top-0">Chức năng</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                      <c:forEach var="u" items="${departs}">
                                        <tr>
                                        <input class="departId"  value="${u.id}" type="hidden" />                                           
                                            <td class="txt-oflo">${u.codeId}</td>
                                            <td class="departName" >${u.name} </td>
                                             <td>
                                             <form>
                      <a href="addDeparts"><button type="button">Thêm</button></a>
                     <a href="updateDeparts?id=${u.id}"><button type="button">Sửa</button></a>
                     <button type="button" class="delete">Xóa</button>
                      </form>
                      </td>
                                        </tr>
                                       </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
               
                <div class="row">
                    <!-- column -->
                    <div class="col-lg-6">
                        
                    </div>
                    <!-- column -->
                    <div class="col-lg-6">
                        

                    </div>
                </div>
             
            </div>
           
            <footer class="footer text-center">
                All Rights Reserved by Nice admin. Designed and Developed by
                <a href="https://wrappixel.com">WrapPixel</a>.
            </footer>
           
        </div>
     
    </div>
  
   
</body>

</html>
