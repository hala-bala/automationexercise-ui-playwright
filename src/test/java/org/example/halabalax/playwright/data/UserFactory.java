package org.example.halabalax.playwright.data;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserFactory {
    private static final Logger LOGGER = Logger.getLogger(UserFactory.class.getName());
    private static final String USER_DATA_PATH = "testdata/users.json";
    private static final List<NewUser> users = loadUsers();
    private static final Random random = new Random();

    private UserFactory() {
    }

    /**
     * Returns a randomly selected user from the loaded data.
     *
     * @return A random NewUser object
     * @throws IllegalStateException if no users are available
     */
    public static NewUser getRandomUser() {
        if (users.isEmpty()) {
            throw new IllegalStateException("No users available");
        }
        return users.get(random.nextInt(users.size()));
    }

    /**
     * Returns an unmodifiable view of all loaded users.
     *
     * @return List of all users
     */
    public static List<NewUser> getAllUsers() {
        return Collections.unmodifiableList(users);
    }

    private static List<NewUser> loadUsers() {
        List<NewUser> loadedUsers = new ArrayList<>();
        ObjectMapper mapper = new ObjectMapper();

        try (InputStream inputStream = UserFactory.class.getClassLoader()
                .getResourceAsStream(USER_DATA_PATH)) {

            if (inputStream == null) {
                LOGGER.severe("Could not find resource: " + USER_DATA_PATH);
                return loadedUsers;
            }

            loadedUsers = mapper.readValue(inputStream, new TypeReference<>() {
            });
            LOGGER.info("Successfully loaded " + loadedUsers.size() + " users");

        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Failed to load users from " + USER_DATA_PATH, e);
        }

        return loadedUsers;
    }
}