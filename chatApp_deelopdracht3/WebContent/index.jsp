<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
    <jsp:include page="head.jsp">
        <jsp:param name="title" value="Home" />
    </jsp:include>

    <body>

        <jsp:include page="header.jsp">
            <jsp:param name="title" value="Home" />
        </jsp:include>

        <script type="text/javascript" src="js/status.js"></script>

        <main>
            <c:if test="${errors.size()>0 }">
                <div class="danger">
                    <ul>
                        <c:forEach var="error" items="${errors }">
                            <li>${error }</li>
                        </c:forEach>
                    </ul>
                </div>
            </c:if>
            <c:choose>
                <c:when test="${user!=null}">

                    <section id="userdashboard">

                        <form method="post" action="Controller?action=LogOut">
                            <p>
                                <input type="submit" id="logoutbutton" value="Log Out">
                            </p>
                        </form>


                    </section><!-- /userdashboard -->


                    <section id="chatcontainer">

                        <div id="chatcanvas">

                            <p>Admin: Welkom bij Lenni's Chat App, ${user.getFirstName()}!</p>
                            <p>Admin: Vul de naam van een vriend in het linkerveld en het bericht dat je wilt sturen in het rechterveld.</p>
                        </div>

                        <div id="chatcontrols">

                            <input type="text" id="friendselector" />
                            <input type="text" id="chatmessage" />

                            <button id="chatbutton">Send</button>

                        </div>

                        <script type="text/javascript" src="js/jquery-1.11.0.js"></script>
                        <script type="text/javascript" src="js/chat.js"></script>
                    </section><!-- /chatcontainer -->


                </c:when>
                <c:otherwise>

                    <section id="loginform">

                        <form method="post" action="Controller?action=LogIn">
                            <p>
                                <label for="email">Your email </label>
                                <input type="text" id="email" name="email" value="jan@ucll.be">
                            </p>
                            <p>
                                <label for="password">Your password</label>
                                <input type="password" id="password" name="password" value="t">
                            </p>
                            <p>
                                <input type="submit" id="loginbutton" value="Log in">
                            </p>
                        </form>

                    </section>

                </c:otherwise>


            </c:choose>

            <jsp:include page="blog.jspf" />

            <jsp:include page="footer.jsp">
                <jsp:param name="title" value="Home" />
            </jsp:include>
        </main>
    </body>
</html>