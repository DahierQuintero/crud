package "Simple CRUD" {
    package "User" {
    }

    package "Account" {
    }

    storage "intermediate"
    [User] --> [intermediate] : "Consumer"

    [Account] --> [intermediate] : "Producer"

    database "AccountDB"

    [Account] --> [AccountDB]
}
