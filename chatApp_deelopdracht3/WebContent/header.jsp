<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<header role="banner">
<h1><span>Lenni's Chat App</span></h1>
<nav>
<ul>
<c:choose>
<c:when test="${param.title=='Home'}">
<li  id="actual"><a href="Controller">Home</a></li>
</c:when>
<c:otherwise>
<li><a href="Controller">Home</a></li>
</c:otherwise>
</c:choose>
</ul>
</nav>

    <c:choose>

        <c:when test="${user!=null}">
            <div id="statusselector">

                <select name="status" id="status">
                    <option value="Online">Online</option>
                    <option value="Offline">Offline</option>
                    <option value="Away">Away</option>
                    <option value="Other">Other</option>
                </select>

                <input type="text" name="other" value="Other" id="otherstatus">

                <p id="tempstatus" style="color:#a80f0c; font-size: 30px;"></p>
            </div>

            <input type="text" id="friendtextbox" />
            <input type="button" value="Add Friend" id="addfriendbutton" />

            <p id="Toggler">Toggle Friend List</p>

            <ul id="friendList">


            </ul>
        </c:when>
    </c:choose>

    <h2>
${param.title}
</h2>

</header>