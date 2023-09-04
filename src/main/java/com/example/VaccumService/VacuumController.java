package com.example.VaccumService;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VacuumController {
    private int currentRoom = 1;
    private final List<Integer> path = new ArrayList<>();
    private int roomsCleaned = 0;

    @PostMapping("/move")
    public void moveToRoom(@RequestParam int room) {
        if (room != currentRoom) {
            path.add(room);
        }
        currentRoom = room;
        roomsCleaned++;
    }

    @GetMapping("/status")
    public int getCurrentRoom() {
        return currentRoom;
    }

    @GetMapping("/path")
    public List<Integer> getPath() {
        return path;
    }

    @GetMapping("/roomsCleaned")
    public int getRoomsCleaned() {
        return roomsCleaned;
    }
}


//Running the Services
//Run VacuumService on port 8081: ./mvnw spring-boot:run -Dspring-boot.run.arguments=--server.port=8081
//Run ControlService on port 8080: ./mvnw spring-boot:run
//Use Postman to make a POST request to http://localhost:8080/clean with JSON body for batches and priority rooms as query parameters.
