package dev.mashei.datastoredemoproject.domain;

import java.util.List;

public record Project(
        String productName,
        String canonicalName,
        String teamName,
        String businessUnit,
        String financeUnit,
        String slackChannel,
        List<String> components) {}
