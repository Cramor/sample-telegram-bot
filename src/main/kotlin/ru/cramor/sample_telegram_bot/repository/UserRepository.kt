package ru.cramor.sample_telegram_bot.repository

import org.springframework.stereotype.Repository

@Repository
class UserRepository {

    private val users: MutableMap<Long, User> = HashMap()

    fun userExists(id: Long) = users.containsKey(id)

    fun addUser(id: Long) {
        users[id] = User(id)
    }
}