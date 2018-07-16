<%@page contentType="text/html; charset=UTF-8" %>
<html>
    <body>
        <h2>Hello World!</h2>
        <a href="/hello">hello</a><hr/>
        <a href="/test?user='小华'">test</a>
        <form action="/test" method="get">
            <input type="text" name="user">
            <input type="submit" value="提交">
        </form>
    </body>
</html>
