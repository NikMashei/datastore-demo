package dev.mashei.datastoredemoproject.application;

import dev.mashei.datastoredemoproject.domain.Team;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface TeamPort {

    Flux<Team> getTeams();

    Mono<Team> findByName(String name);
}
