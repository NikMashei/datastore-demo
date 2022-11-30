package dev.mashei.datastoredemoproject.domain;

import java.util.List;

public interface Team {

    String name();

    String email();

    List<String> members();

    List<Product> products();
}
