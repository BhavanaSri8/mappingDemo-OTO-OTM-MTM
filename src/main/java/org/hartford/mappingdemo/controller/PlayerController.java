package org.hartford.mappingdemo.controller;

import org.hartford.mappingdemo.model.Player;
import org.hartford.mappingdemo.model.Team;
import org.hartford.mappingdemo.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/players")
public class PlayerController {
    @Autowired
    PlayerService playerService;

    @PostMapping
    public Player addPlayer(@RequestBody Player player){
        return playerService.addPlayer(player);
    }

    @GetMapping("/{id}")
    public Player getById(@PathVariable Long id){
        return playerService.getById(id);
    }
    
    @GetMapping
    public List<Player> findAll(){
        return playerService.findAll();
    }
    
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id){
        playerService.deleteById(id);
    }
    
    @PutMapping("/{id}")
    public Player updatePlayer(@PathVariable Long id, @RequestBody Player player){
        return playerService.updatePlayer(id, player);
    }
    
    @GetMapping("/bind/{playerId}/{teamId}")
    public Player bindPlayerToTeam(@PathVariable Long playerId, @PathVariable Long teamId){
        return playerService.bindPlayerToTeam(playerId, teamId);
    }
    
    @GetMapping("/{playerId}/team")
    public Team getTeamByPlayerId(@PathVariable Long playerId){
        return playerService.getTeamByPlayerId(playerId);
    }
}
