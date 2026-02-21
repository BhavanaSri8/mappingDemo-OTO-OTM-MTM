package org.hartford.mappingdemo.service;

import org.hartford.mappingdemo.model.Player;
import org.hartford.mappingdemo.model.Team;
import org.hartford.mappingdemo.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamService {
    @Autowired
    TeamRepository teamRepository;
    
    public Team addTeam(Team team){
        return teamRepository.save(team);
    }
    
    public Team getById(Long id){
        return teamRepository.findById(id).orElseThrow(()->new RuntimeException("Invalid id"));
    }
    
    public List<Team> findAll(){
        return teamRepository.findAll();
    }
    
    public void deleteById(Long id){
        teamRepository.deleteById(id);
    }
    
    public Team updateTeam(Long id, Team team){
        Team existing = getById(id);
        existing.setName(team.getName());
        return teamRepository.save(existing);
    }
    
    public List<Player> getPlayersByTeamName(String name){
        Team team = teamRepository.findByName(name).orElseThrow(()->new RuntimeException("Team not found"));
        return team.getPlayers();
    }
    
    public List<Player> getPlayersByTeamId(Long teamId){
        Team team = getById(teamId);
        return team.getPlayers();
    }
}
