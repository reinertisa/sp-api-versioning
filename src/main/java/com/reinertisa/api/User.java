package com.reinertisa.api;

public record User(
        Integer id,
        String name,
        String email,

        // a lot more fields here
        String website) {
}
