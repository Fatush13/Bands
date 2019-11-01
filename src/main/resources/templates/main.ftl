<html>
    <head>
        <title>Main Page</title>
    </head>
    <body>
    <list>
        <form action="/logout" method="post">
            <input type="hidden" name="_csrf" value="${_csrf.token}"/>
            <input type="submit" value="Sign Out"/>
        </form>
        <form method="post" action="filter">
            <input type="text" name="filter" placeholder="Search by name"/>
            <input type="hidden" name="_csrf" value="${_csrf.token}"/>
            <button type="submit">Search</button>
        </form>
    </list>
        <div>List of bands:</div>
        <table>
            <#list bands as band>
                <tr>
                    <div>
                        <td><b>${band.name}</b></td>
                        <td><span>${band.genre}</span></td>
                        <td><i>${band.origin}</i></td>
                        <td><strong>{foundation}</strong></td>
                        <td>
                            <#if filename??>
                                <img src="/img/${band.filename}" height="75" width="75">
                            </#if>
                        </td>
                    </div>
                </tr>
            </#list>
        </table>
        <a href="/adding">Add new band</a>
    </body>
</html>
