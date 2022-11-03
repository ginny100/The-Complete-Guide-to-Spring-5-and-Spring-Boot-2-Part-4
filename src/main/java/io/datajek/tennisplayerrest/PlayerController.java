package io.datajek.tennisplayerrest;

import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

@RestController
public class PlayerController {

    @Autowired
    PlayerService service;

    @GetMapping("/players")
    public List<Player> allPlayers() {
        return service.getAllPlayers();
    }

    @GetMapping("/players/{id}")
    public Player getPlayer(@PathVariable int id){
        return service.getPlayer(id);
    }

    @PostMapping("/players")
    public Player addPlayer(@RequestBody Player player) {
        player.setId(0);
        return service.addPlayer(player);
    }

    @PutMapping("/players/{id}")
    public Player updatePlayer(@RequestBody Player player, @PathVariable int id) {
        return service.updatePlayer(id, player);
    }

    @PutMapping("/players/2/{id}")
    public Player updatePlayer2(@RequestBody Player player, @PathVariable int id) {
        return service.updatePlayer2(id, player);
    }

    @PatchMapping("/players/{id}")
    public Player partialUpdate(@PathVariable int id, @RequestBody Map<String, Object> playerPatch) {
        return service.patch(id, playerPatch);
    }

    @PatchMapping("/players/{id}/titles")
    public void updateTitles(@PathVariable int id, @RequestBody int titles) {
        service.updateTitles(id, titles);
    }

    @DeleteMapping("/players/{id}")
    public String deletePlayer(@PathVariable int id) {
        return service.deletePlayer(id);
    }

    @DeleteMapping("/players/2/{id}")
    public void deletePlayer2(@PathVariable int id) {
        service.deletePlayer2(id);
    }
}