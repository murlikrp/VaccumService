package com.example.ControlService;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@RestController
public class ControlController {
    private final RestTemplate restTemplate = new RestTemplate();
    private final String vacuumServiceUrl = "http://localhost:8081";  // Assuming VacuumService runs on port 8081

    @PostMapping("/clean")
    public Map<String, Object> clean(@RequestBody List<List<Integer>> batches, @RequestParam List<Integer> priorityRooms) {
        int totalCleaned = 0;
        int batchesProcessed = 0;
        int roomsPassed = 0;
        List<List<Integer>> actualPath = new ArrayList<>();

        // Your Optimization logic here

        // Final output
        Map<String, Object> result = new HashMap<>();
        result.put("Actual Path", actualPath);
        result.put("Total Rooms Cleaned", totalCleaned);
        result.put("Batches Processed", batchesProcessed);
        result.put("Rooms Passed Without Cleaning", roomsPassed);
        result.put("Final Room", restTemplate.getForObject(vacuumServiceUrl + "/status", Integer.class));
        
        return result;
    }
}
