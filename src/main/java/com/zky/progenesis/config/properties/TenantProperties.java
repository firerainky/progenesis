package com.zky.progenesis.config.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Data;

@ConfigurationProperties(prefix = "tenant")
@Data
public class TenantProperties {
    private Boolean enable = true;
    private String column = "tenant_id";
    // private List<String> ignoreTables;
}
