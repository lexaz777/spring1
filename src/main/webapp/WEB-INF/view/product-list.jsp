<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>

<html>
<body>
<h1>Products</h1>
<br>
<c:forEach var="product" items="${products}">
First name: ${product.id}
<br>
Last name: ${product.title}
<br>
Country: ${product.coast}
<br>
</c:forEach>


</body>
</html>