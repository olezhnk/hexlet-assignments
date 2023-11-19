@import exercise.dto.users.UsersPage
@import exercise.model.User
@param UsersPage page


<html lang="ru">
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <title>Хекслет</title>
</head>
<body>
<h1>${page.getHeader()}</h1>
@if(page.getUsers().isEmpty())
    <p>Пока не добавлено ни одного пользователя</p>
@else
    @for(User user : page.getUsers())
        <div>
            <h2><a href="/users/${user.getId()}">${user.getFirstName() + " " + user.getLastName()}</a></h2>
            <p>${user.getEmail()}</p>
        </div>
    @endfor
@endif
</body>
</html>
