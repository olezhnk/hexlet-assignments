@import exercise.dto.users.UserPage

@param UserPage page

@template.layout.page(content = @`
    <div>
        <p>id - ${page.getUser().getId()}</p>
        <p>${page.getUser().getFirstName()} ${page.getUser().getLastName()}</p>
        <p>почта - ${page.getUser().getEmail()}</p>
    </div>
`)