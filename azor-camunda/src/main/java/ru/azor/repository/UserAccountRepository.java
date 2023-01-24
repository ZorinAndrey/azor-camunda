package ru.azor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.azor.entity.UserAccount;

/**
 * Repository for entity {@link UserAccount}
 */

@Repository
public interface UserAccountRepository extends JpaRepository<UserAccount, Long> {

    /**
     * Method to find user account by username.
     *
     * @param username username of user
     * @return {@link UserAccount}
     */
    UserAccount findByUsername(String username);
}
