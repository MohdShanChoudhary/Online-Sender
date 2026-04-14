package com.shan.onlinesender.controller;

import com.shan.onlinesender.service.ClipboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/clipboard")
@CrossOrigin(origins = "*")
public class ClipboardController {

    @Autowired
    private ClipboardService clipboardService;

    /**
     * Create a new clipboard
     * POST /api/clipboard
     * Body: { "content": "text here", "expiryHours": 24 }
     */
    @PostMapping
    public ResponseEntity<Map<String, String>> createClipboard(@RequestBody Map<String, Object> request) {
        // Extract content from request
        String content = (String) request.get("content");

        // Extract expiry hours (default to 24)
        Integer expiryHours = 24;
        if (request.get("expiryHours") != null) {
            try {
                expiryHours = Integer.parseInt(request.get("expiryHours").toString());
            } catch (NumberFormatException e) {
                expiryHours = 24;
            }
        }

        // Validate content
        if (content == null || content.trim().isEmpty()) {
            Map<String, String> error = new HashMap<>();
            error.put("error", "Content cannot be empty");
            return ResponseEntity.badRequest().body(error);
        }

        // Create clipboard
        String code = clipboardService.createClipboard(content, expiryHours);

        // Prepare response
        Map<String, String> response = new HashMap<>();
        response.put("code", code);
        response.put("message", "Clipboard created successfully");

        return ResponseEntity.ok(response);
    }

    /**
     * Retrieve clipboard by code
     * GET /api/clipboard/{code}
     */
    @GetMapping("/{code}")
    public ResponseEntity<?> getClipboard(@PathVariable String code) {
        // Get clipboard from service
        Map<String, Object> clipboard = clipboardService.getClipboard(code);

        // Check if found
        if (clipboard == null) {
            Map<String, String> error = new HashMap<>();
            error.put("error", "Clipboard not found or expired");
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(clipboard);
    }

    /**
     * Health check endpoint
     * GET /api/clipboard/health
     */
    @GetMapping("/health")
    public ResponseEntity<Map<String, String>> health() {
        Map<String, String> response = new HashMap<>();
        response.put("status", "UP");
        response.put("service", "Online Sender by Shan");
        response.put("version", "1.0.0");
        return ResponseEntity.ok(response);
    }
}