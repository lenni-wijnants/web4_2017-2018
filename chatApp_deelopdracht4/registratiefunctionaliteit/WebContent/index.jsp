<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
    <jsp:include page="head.jsp"/>

    <body>
        <main>
            <form method="POST" action="Controller?action=RegisterHandler">

                <label for="email">Email</label>
                <input type="email" id="email" name="email" required />

                <label for="password">Password</label>
                <input type="password" id="password" name="password" required />

                <label for="secondpassword">Confirm Password</label>
                <input type="password" id="secondpassword" name="secondpassword" required />

                <label for="firstname">First Name</label>
                <input type="text" id="firstname" name="firstname" required />

                <label for="lastname">Last Name</label>
                <input type="text" id="lastname" name="lastname" required />

                <label for="gender">Gender</label>
                <input type="text" id="gender" name="gender" required />

                <label for="age">Age</label>
                <input type="number" id="age" name="age" required />

                <input type="submit" value="Register" />
            </form>
        </main>

        <jsp:include page="footer.jsp"/>
    </body>
</html>