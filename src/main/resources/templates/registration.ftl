<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <title>Spring Security Example </title>
    </head>
    <body>
        <b>Add new user</b>
        <form action="/registration" method="post">
            <div><label> User Name : <input type="text" name="username"  placeholder="Enter new username"/> </label></div>
            <div><label> Password: <input type="password" name="password"  placeholder="Enter some password"/> </label></div>
            <input type="hidden" name="_csrf" value="${_csrf.token}" />
            <div><input type="submit" value="Sign Up"/></div>
        </form>
    </body>
</html>