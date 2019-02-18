<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>

<html>
<body>
<form:form action="processForm" modelAttribute="product">
    id: <form:input path="id"/>
    <br>
    title: <form:input path="title"/>
    <<br>>
    coast: <form:input path="coast"/>
    <br>
    <input type="submit" value="Submit"/>
</form:form>
</body>
</html>
