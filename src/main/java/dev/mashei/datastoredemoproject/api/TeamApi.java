package dev.mashei.datastoredemoproject.api;

import dev.mashei.datastoredemoproject.application.TeamPort;
import dev.mashei.datastoredemoproject.domain.Team;
import lombok.RequiredArgsConstructor;
import org.reactivestreams.Publisher;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("teams")
@RequiredArgsConstructor
public class TeamApi {

    private final TeamPort teamPort;

    @GetMapping
    Publisher<Team> getTeams(@RequestParam String teamName) {
        if (StringUtils.hasText(teamName)) {
            return teamPort.findByName(teamName);
        }
        return teamPort.getTeams();
    }
}
