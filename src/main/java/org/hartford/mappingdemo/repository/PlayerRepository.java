package org.hartford.mappingdemo.repository;

import org.hartford.mappingdemo.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Player, Long> {
}
