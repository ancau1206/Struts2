<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>

<html dir="ltr" lang="en">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!-- Tell the browser to be responsive to screen width -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <!-- Favicon icon -->
   
    <title>Nice admin Template - The Ultimate Multipurpose admin template</title>
    <style type="text/css">
    .form2 {
    margin-right: 230px;
    margin-left:530px;
    width: 300px;
    margin-top: 50px;
    
    }
    
    
    </style>
    <!-- Custom CSS -->
   
    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    
<![endif]-->
</head>

<body>
    <!-- ============================================================== -->
    <!-- Preloader - style you can find in spinners.css -->
    <!-- ============================================================== -->
    <div class="preloader">
        <div class="lds-ripple">
            <div class="lds-pos"></div>
            <div class="lds-pos"></div>
        </div>
    </div>
    <jsp:include page="../include/header.jsp" />
		<!-- aside -->
		<jsp:include page="../include/aside.jsp" />
  
               
                    <div class="form2">
                            
                            <s:form action="addRecords" method="post" validate="true"  >
                            <s:hidden name="staffs.id"/>
                           <label>Kiểu</label>
                            <s:radio name="type" list="#{'1':'Thành tích','0':'Kỉ luật'}"  />
                               <label>Lí do</label>
                                 <s:textfield name="reason" size="50" />
                                 
                                <s:submit method="execute"  value="Create" align="center" />
                            </s:form>
                        
                </div>

               
            <footer class="footer text-center">
                All Rights Reserved by Nice admin. Designed and Developed by
                <a href="https://wrappixel.com">WrapPixel</a>.
            </footer>
            <!-- ============================================================== -->
            <!-- End footer -->
            <!-- ============================================================== -->
     
        <!-- ============================================================== -->
        <!-- End Page wrapper  -->
        <!-- ============================================================== -->
   
    <!-- ============================================================== -->
    <!-- End Wrapper -->
    <!-- ============================================================== -->
    <!-- ============================================================== -->
    <!-- All Jquery -->
    <!-- ============================================================== -->
   
</body>

</html>