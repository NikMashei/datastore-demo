package dev.mashei.datastoredemoproject.application;

import dev.mashei.datastoredemoproject.domain.Product;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ProductPort {

    Mono<Product> findByCanonicalName(String canonicalName);

    Flux<Product> getProducts();
}
