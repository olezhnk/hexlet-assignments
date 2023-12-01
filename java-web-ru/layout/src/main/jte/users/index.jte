@import exercise.dto.users.UsersPage

@param UsersPage page

@template.layout.page(content = @`
    @if(page.getUsers().isEmpty())
        <p>Список пользователей пуст</p>
    @else
        @for(var user : page.getUsers())
            <div>
                <p>id - ${user.getId()}</p>
                <p>${user.getFirstName()} ${user.getLastName()}</p>
                <p>почта - ${user.getEmail()}</p>
            </div>
        @endfor
    @endif
`)