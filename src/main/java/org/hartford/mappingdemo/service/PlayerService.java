package org.hartford.mappingdemo.service;

import org.hartford.mappingdemo.model.Player;
import org.hartford.mappingdemo.model.Team;
import org.hartford.mappingdemo.repository.PlayerRepository;
import org.hartford.mappingdemo.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerService {
    @Autowired
    PlayerRepository playerRepository;
    @Autowired
    TeamRepository teamRepository;
    
    public Player addPlayer(Player player){
        return playerRepository.save(player);
    }
    
    public Player getById(Long id){
        return playerRepository.findById(id).orElseThrow(()->new RuntimeException("Invalid id"));
    }
    
    public List<Player> findAll(){
        return playerRepository.findAll();
    }
    
    public void deleteById(Long id){
        playerRepository.deleteById(id);
    }
    
    public Player updatePlayer(Long id, Player player){
        Player existing = getById(id);
        existing.setFname(player.getFname());
        existing.setLname(player.getLname());
        return playerRepository.save(existing);
    }
    
    public Player bindPlayerToTeam(Long playerId, Long teamId){
        Player player = playerRepository.findById(playerId).orElseThrow(()->new RuntimeException("Invalid player id"));
        Team team = teamRepository.findById(teamId).orElseThrow(()->new RuntimeException("Invalid team id"));
        player.setTeam(team);
        return playerRepository.save(player);
    }
    
    public Team getTeamByPlayerId(Long playerId){
        Player player = getById(playerId);
        return player.getTeam();
    }
}
