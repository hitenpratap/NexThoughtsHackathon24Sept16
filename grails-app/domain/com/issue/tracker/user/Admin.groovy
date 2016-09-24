package com.issue.tracker.user

import com.issue.tracker.authentication.User

class Admin extends User {

    Admin() {}

    Admin(Integer num) {
        this.username = "admin${num + 1}@email.com"
        this.password = "fin1928tech"
    }

}
