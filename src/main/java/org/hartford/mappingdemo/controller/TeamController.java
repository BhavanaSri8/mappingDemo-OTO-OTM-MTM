package org.hartford.mappingdemo.controller;

import org.hartford.mappingdemo.model.Player;
import org.hartford.mappingdemo.model.Team;
import org.hartford.mappingdemo.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teams")
public class TeamController {
    @Autowired
    TeamService teamService;

    @PostMapping
    public Team addTeam(@RequestBody Team team){
        return teamService.addTeam(team);
    }

    @GetMapping("/{id}")
    public Team getById(@PathVariable Long id){
        return teamService.getById(id);
    }
    
    @GetMapping
    public List<Team> findAll(){
        return teamService.findAll();
    }
    
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id){
        teamService.deleteById(id);
    }
    
    @PutMapping("/{id}")
    public Team updateTeam(@PathVariable Long id, @RequestBody Team team){
        return teamService.updateTeam(id, team);
    }
    
    @GetMapping("/players/{teamName}")
    public List<Player> getPlayersByTeamName(@PathVariable String teamName){
        return teamService.getPlayersByTeamName(teamName);
    }
    
    @GetMapping("/{teamId}/players")
    public List<Player> getPlayersByTeamId(@PathVariable Long teamId){
        return teamService.getPlayersByTeamId(teamId);
    }
}
