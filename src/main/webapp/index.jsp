<html>
<body>
	<h2>Hello World!</h2>

	<%=java.util.Calendar.getInstance().getTime()%>
	<form action="hello.html" method="post">
		Name:<input type="text" name="name" /><br /> Password:<input
			type="password" name="password" /><br /> <input type="submit"
			value="login" />
	</form>
</body>
</html>
