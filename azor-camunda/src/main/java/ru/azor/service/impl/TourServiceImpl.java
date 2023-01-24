package ru.azor.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.azor.entity.Tour;
import ru.azor.repository.TourRepository;
import ru.azor.service.TourService;

import java.util.List;

/**
 * {@inheritDoc}.
 */

@Service
@Slf4j
@RequiredArgsConstructor
public class TourServiceImpl implements TourService {

    private final TourRepository tourRepository;

    /**
     * {@inheritDoc}.
     */
    @Override
    public List<Tour> findAllToursByUserAccountId(Long userId) {
        return tourRepository.findAllTourByUserAccountId(userId);
    }

    /**
     * {@inheritDoc}.
     */
    @Override
    public Tour save(Tour tour) {
        return tourRepository.save(tour);
    }
}
