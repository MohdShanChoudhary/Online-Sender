package com.shan.onlinesender.service;

import com.shan.onlinesender.model.Clipboard;
import com.shan.onlinesender.repository.ClipboardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Random;

@Service
public class ClipboardService {

    @Autowired
    private ClipboardRepository repository;

    private static final String CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private static final int CODE_LENGTH = 6;

    /**
     * Create a new clipboard entry
     * @param content The text content to save
     * @param expiryHours Number of hours until expiry
     * @return The unique code for the clipboard
     */
    @Transactional
    public String createClipboard(String content, Integer expiryHours) {
        // Validate and set default expiry
        if (expiryHours == null || expiryHours <= 0) {
            expiryHours = 24;
        }

        // Generate unique code
        String code = generateUniqueCode();

        // Create clipboard object
        Clipboard clipboard = new Clipboard();
        clipboard.setCode(code);
        clipboard.setContent(content);
        clipboard.setCreatedAt(LocalDateTime.now());
        clipboard.setExpiresAt(LocalDateTime.now().plusHours(expiryHours));
        clipboard.setViewCount(0);

        // Save to database
        repository.save(clipboard);

        System.out.println("✅ Created clipboard with code: " + code);
        return code;
    }

    /**
     * Retrieve clipboard by code
     * @param code The unique code
     * @return Map containing clipboard data or null if not found/expired
     */
    @Transactional
    public Map<String, Object> getClipboard(String code) {
        // Find clipboard by code
        Optional<Clipboard> clipboardOpt = repository.findByCode(code.toUpperCase());

        if (clipboardOpt.isEmpty()) {
            System.out.println("❌ Clipboard not found: " + code);
            return null;
        }

        Clipboard clipboard = clipboardOpt.get();

        // Check if expired
        if (clipboard.getExpiresAt().isBefore(LocalDateTime.now())) {
            System.out.println("⏰ Clipboard expired: " + code);
            repository.delete(clipboard);
            return null;
        }

        // Increment view count
        clipboard.setViewCount(clipboard.getViewCount() + 1);
        repository.save(clipboard);

        System.out.println("✅ Retrieved clipboard: " + code + " (Views: " + clipboard.getViewCount() + ")");

        // Prepare response
        Map<String, Object> response = new HashMap<>();
        response.put("code", clipboard.getCode());
        response.put("content", clipboard.getContent());
        response.put("createdAt", clipboard.getCreatedAt().toString());
        response.put("expiresAt", clipboard.getExpiresAt().toString());
        response.put("viewCount", clipboard.getViewCount());

        return response;
    }

    /**
     * Generate a unique 6-character code
     * @return Unique code
     */
    private String generateUniqueCode() {
        Random random = new Random();
        String code;

        do {
            StringBuilder sb = new StringBuilder(CODE_LENGTH);
            for (int i = 0; i < CODE_LENGTH; i++) {
                sb.append(CHARS.charAt(random.nextInt(CHARS.length())));
            }
            code = sb.toString();
        } while (repository.findByCode(code).isPresent());

        return code;
    }

    /**
     * Scheduled task to cleanup expired clipboards
     * Runs every hour
     */
    @Scheduled(fixedRate = 3600000) // 3600000ms = 1 hour
    @Transactional
    public void cleanupExpiredClipboards() {
        LocalDateTime now = LocalDateTime.now();
        repository.deleteByExpiresAtBefore(now);
        System.out.println("🧹 Cleaned up expired clipboards at: " + now);
    }
}