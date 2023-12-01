@import gg.jte.Content

@param Content content

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Test page with layouts</title>
</head>
<body>
<div class="header">
    <h2><a href = "/">Главная страница</a> <a href = "/users">Пользователи</a></h2>
</div>
${content}
<div class="footer">
    <h2><a href = "https://github.com/olezhnk">olezNk's github</a></h2>
</div>
</body>
</html>