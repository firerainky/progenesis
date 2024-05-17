package com.zky.progenesis.config;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserContext {
    private String loginName;
    private String organizationId;
    private String roleRange;
}
