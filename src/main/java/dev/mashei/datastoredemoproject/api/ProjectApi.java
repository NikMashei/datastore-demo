package dev.mashei.datastoredemoproject.api;

import dev.mashei.datastoredemoproject.application.ProjectsPort;
import dev.mashei.datastoredemoproject.domain.Project;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("projects")
@RequiredArgsConstructor
public class ProjectApi {

    private final ProjectsPort projectsPort;

    @GetMapping
    Flux<Project> getProjects() {
        return projectsPort.getProjects();
    }

    @GetMapping("canonical-name")
    Mono<Project> getProjectByName(@RequestParam String canonicalName) {
        return projectsPort.findProjectByCanonicalName(canonicalName);
    }
}
