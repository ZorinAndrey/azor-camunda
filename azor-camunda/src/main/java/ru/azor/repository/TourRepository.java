package ru.azor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.azor.entity.Tour;

import java.util.List;

/**
 * Repository for entity {@link Tour}
 */

@Repository
public interface TourRepository extends JpaRepository<Tour, Long> {

    /**
     * Method to find the tour by user account identifier.
     *
     * @param userId user account identifier
     * @return {@link Tour}
     */
    List<Tour> findAllTourByUserAccountId(Long userId);
}
