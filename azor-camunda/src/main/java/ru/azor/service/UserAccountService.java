package ru.azor.service;

import ru.azor.entity.UserAccount;

/**
 * Service fo entity {@link ru.azor.entity.UserAccount}
 */

public interface UserAccountService {

    /**
     * Method to find user account by username.
     *
     * @param username username of user
     * @return {@link UserAccount}
     */
    UserAccount findByUsername(String username);

    /**
     * Method to save user account.
     *
     * @param userAccount saving user account
     * @return saved {@link UserAccount}
     */
    UserAccount save(UserAccount userAccount);
}
