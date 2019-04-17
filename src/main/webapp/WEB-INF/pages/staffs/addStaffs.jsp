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
                    <s:actionerror />
	<s:if test="#request.error != ''">
            <font color="red">
               <s:property value="%{#request.error}"/>
            </font>
        </s:if>
                            <s:form  action="addStaffs" method="post" validate="true">
                           
                            <label>Mã nhân viên</label>
                               <s:textfield name="codeId"   size="50"  />
                                 <label>Tên nhân viên</label>
                                 <s:textfield name="name"  size="50" />
                                 <label>Phòng ban</label>
                               <s:select id="departs" headerKey="-1"  list="listDeparts"  listKey="id" listValue="name"
		name="departs.id" />
                                 <label>Giới tính</label>
                                <s:radio name="gender" list="#{'true':'Nam','false':'Nữ'}"  />
                                 
                                 <label>Email</label>
                                 <s:textfield name="email"  size="50" />
                                 
                                 <label>Ảnh</label>
                                 <s:textfield name="photo"  size="50" />
                                
                                 <label>Cấp độ</label>
                                <s:select headerKey="-1"  width="50"
		list="#{'1':'1', '2':'2', '3':'3', '4':'4', '5':'5', '6':'6', '7':'7', '8':'8', '9':'9', '10':'10'}" 
		name="level" 
		value="level" />
                                
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