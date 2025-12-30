package com.reinertisa.api.config;

public class ApiVersionParser implements org.springframework.web.accept.ApiVersionParser {
    @Override
    public Comparable parseVersion(String version) {
        // Remove "v" prefix if it exists (v1 becomes 1, v2 becomes 2)
        if (version.startsWith("v") || version.startsWith("V")) {
            version = version.substring(1);
        }

        // Add .0 if it's just a single number (1 become 1.0, 2 become 2.0)
        if (!version.contains(".")) {
            version = version + ".0";
        }

        return version;
    }
}
