package ru.azor.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.azor.entity.UserAccount;
import ru.azor.repository.UserAccountRepository;
import ru.azor.service.UserAccountService;

/**
 * {@inheritDoc}.
 */

@Service
@Slf4j
@RequiredArgsConstructor
public class UserAccountServiceImpl implements UserAccountService {

    private final UserAccountRepository userAccountRepository;

    /**
     * {@inheritDoc}.
     */
    @Override
    public UserAccount findByUsername(String username) {
        return userAccountRepository.findByUsername(username);
    }

    /**
     * {@inheritDoc}.
     */
    @Override
    public UserAccount save(UserAccount userAccount) {
        return userAccountRepository.save(userAccount);
    }
}
