package dev.mashei.datastoredemoproject.api;

import dev.mashei.datastoredemoproject.application.ProductPort;
import dev.mashei.datastoredemoproject.domain.Product;
import lombok.RequiredArgsConstructor;
import org.reactivestreams.Publisher;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("products")
@RequiredArgsConstructor
public class ProductApi {

    private final ProductPort productPort;

    @GetMapping()
    Publisher<Product> getProducts(@RequestParam(name = "name", required = false) String canonicalName) {
        if (StringUtils.hasText(canonicalName)) {
            return productPort.findByCanonicalName(canonicalName);
        }
        return productPort.getProducts();
    }
}
