package com.chat.server;

import com.chat.model.Chat;
import com.chat.model.Database;
import com.chat.model.User;

/**
 * @author Tomas Kozakas
 */
public class Validate {
    private final Database database = new Database();

    public Validate() {
        database.importData();
    }


    public User login(User user) {
        if (!database.containsUser(user.getName())) {
            return null;
        }
        return database.getUser(user.getName()).getPassword().equals(user.getPassword()) ? database.getUser(user.getName()) : null;
    }

    public boolean register(User user) {
        if (database.containsUser(user.getName())) {
            return false;
        }
        database.addUser(user);
        database.exportData();
        return true;
    }

    public User createRoom(User user, Chat chat) {
        if (database.containsChat(chat.getName())) {
            return null;
        }
        user.addChat(chat.getName());
        database.replaceUser(user);
        database.addChat(chat);
        database.exportData();
        return user;
    }

    public User joinRoom(User user, Chat chat) {
        if (!database.containsChat(chat.getName())) {
            return null;
        }
        if (!user.getAvailableChat().contains(chat.getName())) {
            user.addChat(chat.getName());
            database.replaceUser(user);
            database.exportData();
        }
        return user;
    }
}
