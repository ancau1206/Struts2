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
   <link rel="stylesheet" href="https://cdn.datatables.net/1.10.12/css/jquery.dataTables.min.css"/>
 

	 
</head>

<body>

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
                        <h4 class="page-title">Thông tin nhân viên</h4>
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
                                <h4 class="card-title">Danh sách nhân viên</h4>
                            </div>
                            <div class="table-responsive">
                                <table id="example" class="table table-hover">
                                    <thead>
                                        <tr>
                                            <th class="border-top-0">Mã nhân viên</th>
                                            <th class="border-top-0">Phòng ban</th>
                                             <th class="border-top-0">Tên</th>
                                             <th class="border-top-0">Thành tích</th>
                                             <th class="border-top-0">Kỷ luật</th>
                                             <th class="border-top-0">Tổng điểm</th>
                                             <th class="border-top-0">Tác vụ</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                      <c:forEach var="u" items="${records}" varStatus="status">
                                       <tr>
                      <td>${u[0]}</td>
                      <td>${u[5]}</td>
                      <td>${u[1]}</td>
                      <td>${u[2]}</td>
                      <td>${u[3]}</td>
                      <td>${u[4]}</td>
                     	
                      <td>
	                      <form>
		                     <a href="addRecords?id=${u[6]}"><button type="button">Thêm</button></a>
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
  
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script type="text/javascript" src="https://cdn.datatables.net/1.10.12/js/jquery.dataTables.min.js"></script>
    <script>
  $(function(){
    $("#example").dataTable();
  })
  </script>
  
</body>

</html>
