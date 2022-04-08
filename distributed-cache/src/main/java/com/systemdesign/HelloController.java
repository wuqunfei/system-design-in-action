package com.systemdesign;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@RestController
@RequestMapping("/hello")
public class HelloController {

    @GetMapping("/{id}")
    private Mono<String> getHelloString(@PathVariable String id) {
        Mono<String> mono = Mono.just("Hi, " + id);

        return mono;
    }

    @GetMapping("/all")
    private Flux<String> getHelloAll() {
        Flux<String> flux = Flux.just("Hi", "Hello", "Hallo");
        return flux;
    }
}
