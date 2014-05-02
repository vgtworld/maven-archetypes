<%@tag description="Basic template" pageEncoding="UTF-8"%>
<%@attribute name="pageTitle" required="true" type="java.lang.String" %>
<%@attribute name="header" fragment="true"%>
<html>
<head>
	<link rel="stylesheet" type="text/css" href="./css/style.css" />
	<meta http-equiv="Content-type" content="text/html; charset=utf-8" />
	<title>${pageTitle}</title>
</head>
<body>
	<div id="header">
		<jsp:invoke fragment="header" />
	</div>
	<div id="content">
		<jsp:doBody />
	</div>
	<div id="footer">
		<p class="copyright">Copyright &copy; 2014 - <a href="http://vgtworld.pl">VGT</a></p>
	</div>
</body>
</html>
