package com.shan.onlinesender.repository;

import com.shan.onlinesender.model.Clipboard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Optional;

@Repository
public interface ClipboardRepository extends JpaRepository<Clipboard, Long> {

    /**
     * Find clipboard by unique code
     * @param code The 6-character unique code
     * @return Optional containing clipboard if found
     */
    Optional<Clipboard> findByCode(String code);

    /**
     * Delete all clipboards that have expired
     * @param dateTime Current date time
     */
    void deleteByExpiresAtBefore(LocalDateTime dateTime);
}