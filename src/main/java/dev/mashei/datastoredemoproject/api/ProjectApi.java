package dev.mashei.datastoredemoproject.api;

import dev.mashei.datastoredemoproject.application.ProjectsPort;
import dev.mashei.datastoredemoproject.domain.Project;
import lombok.RequiredArgsConstructor;
import org.reactivestreams.Publisher;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("projects")
@RequiredArgsConstructor
public class ProjectApi {

    private final ProjectsPort projectsPort;

    @GetMapping()
    Publisher<Project> getProjectByName(@RequestParam String canonicalName) {
        if (StringUtils.hasText(canonicalName)) {
            return projectsPort.findProjectByCanonicalName(canonicalName);
        }
        return projectsPort.getProjects();
    }
}
