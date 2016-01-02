<%@ tag description="Basic template" pageEncoding="UTF-8" %>
<%@ attribute name="title" required="true" type="java.lang.String" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta http-equiv="Content-type" content="text/html; charset=utf-8"/>
	<title>${title}</title>
</head>
<body>
<div class="content">
	<jsp:doBody/>
</div>
</body>
</html>