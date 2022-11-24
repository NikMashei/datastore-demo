package dev.mashei.datastoredemoproject.application;

import dev.mashei.datastoredemoproject.domain.Project;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ProjectsPort {

    Mono<Project> findProjectByCanonicalName(String canonicalName);

    Flux<Project> getProjects();
}
