<%@ page language="java" import="java.util.*"  pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>Spring MVC Demo</title>
  </head>
  <body>
   <jsp:forward page="login.do" />
   <!--在此处会根据springMvc-servlet.xml文件中查找真正的jsp页面-->
  </body>
</html>