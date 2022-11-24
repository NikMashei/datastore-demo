package dev.mashei.datastoredemoproject.api;

import dev.mashei.datastoredemoproject.application.TeamsPort;
import dev.mashei.datastoredemoproject.domain.Team;
import lombok.RequiredArgsConstructor;
import org.reactivestreams.Publisher;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("teams")
@RequiredArgsConstructor
public class TeamApi {

    private final TeamsPort teamsPort;

    @GetMapping
    Publisher<Team> getTeams(@RequestParam String teamName) {
        if (StringUtils.hasText(teamName)) {
            return teamsPort.findTeamByName(teamName);
        }
        return teamsPort.getTeams();
    }
}
