package dev.mashei.datastoredemoproject.domain;

import java.util.List;

public interface Product {

    String name();

    String canonicalName();

    String teamName();

    String businessUnit();

    String financeUnit();

    String slackChannel();

    List<String> components();
}
