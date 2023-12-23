@import exercise.dto.users.UsersPage
@import exercise.model.User
@param UsersPage page
@template.layout.page(
    content = @`
        <form action="/users" method="get">
        @if (page == null)
            <input type="search" name="term"/>
        @else
            <input type="search" name="term" value="${page.getTerm()}" />
        @endif
        <input type="submit" value="Search" />
        </form>
        @if (!(page == null))
            @for(User user : page.getUsers())
                <div>
                    <p>id - ${user.getId()}</p>
                    <p>${user.getFirstName()} ${user.getLastName()}</p>
                    <p>почта - ${user.getEmail()}</p>
                </div>
            @endfor
        @endif

`)
