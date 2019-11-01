<html>
<head>
    <title>AddingBands</title>
</head>
<body>
    <form method="post" enctype="multipart/form-data">
        <div>Band name:<input type="text" name="name"/></div>
        <div>Band genre:<input type="text" name="genre"/></div>
        <div>Band origin:<input type="text" name="origin"/></div>
        <div>Band foundation:<input type="text" name="foundation"/></div>
        <div>Band Poster:<input type="file" name="file"></div>
        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
        <button type="submit">Add</button>
    </form>
</body>
</html>