package com.backstreetbrogrammer.module1_javaFundamentalsRecap.ch02_oop;

import java.util.List;
import java.util.Map;

public final class ImmutableClass {

    private final long id;
    private final String name;
    private final List<String> tokens;
    private final Map<String, String> metadata;

    public ImmutableClass(final long id, final String name, final List<String> tokens,
                          final Map<String, String> metadata) {
        this.id = id;
        this.name = name;

        // deep copy
        this.tokens = List.copyOf(tokens);
        this.metadata = Map.copyOf(metadata);
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<String> getTokens() {
        // clone
        return List.copyOf(tokens);
    }

    public Map<String, String> getMetadata() {
        // clone
        return Map.copyOf(metadata);
    }

    @Override
    public String toString() {
        return "ImmutableClass{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", tokens=" + tokens +
                ", metadata=" + metadata +
                '}';
    }

}
