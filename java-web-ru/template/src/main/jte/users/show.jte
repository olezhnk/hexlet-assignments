@import exercise.dto.users.UserPage
@import exercise.model.User
@param UserPage page

<html lang="ru">
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <title>${page.getHeader()}</title>
</head>
<body>
<h1>${page.getHeader()}</h1>
<div>
    <h2>id: ${page.getUser().getId()}</h2>
    <p>Full name: ${page.getUser().getFirstName() + " " + page.getUser().getLastName()}</p>
    <p>Email: ${page.getUser().getEmail()}</p>
</div>
</body>
</html>
