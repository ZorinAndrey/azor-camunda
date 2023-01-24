package ru.azor.service;

import ru.azor.entity.Tour;
import ru.azor.entity.UserAccount;

import java.util.List;

/**
 * Service fo entity {@link ru.azor.entity.Tour}
 */
public interface TourService {

    /**
     * Method to find the tours by user account identifier.
     *
     * @param userId user account identifier
     * @return {@link Tour}
     */
    List<Tour> findAllToursByUserAccountId(Long userId);

    /**
     * Method to save tour.
     *
     * @param tour saving tour
     * @return saved {@link Tour}
     */
    Tour save(Tour tour);
}
