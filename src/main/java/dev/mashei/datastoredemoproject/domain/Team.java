package dev.mashei.datastoredemoproject.domain;

import java.util.List;

public record Team(
        String name,
        String email,
        List<String> members) {}
