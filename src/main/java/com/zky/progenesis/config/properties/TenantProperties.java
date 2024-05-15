package com.zky.progenesis.config.properties;

import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Data;

@ConfigurationProperties(prefix = "tenant")
@Data
public class TenantProperties {
    private Boolean enable = true;
    private String column = "tenant_id";
    // private List<String> ignoreTables;

    private List<String> filterTables;
}
