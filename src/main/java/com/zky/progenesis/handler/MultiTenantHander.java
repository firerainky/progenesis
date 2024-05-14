package com.zky.progenesis.handler;

import com.baomidou.mybatisplus.extension.plugins.handler.TenantLineHandler;
import com.zky.progenesis.config.properties.TenantProperties;

import net.sf.jsqlparser.expression.Expression;
import net.sf.jsqlparser.expression.LongValue;

public class MultiTenantHander implements TenantLineHandler {

    private final TenantProperties properties;

    public MultiTenantHander(TenantProperties properties) {
        this.properties = properties;
    }

    @Override
    public Expression getTenantId() {
        return new LongValue(1);
    }
    
    @Override
    public String getTenantIdColumn() {
        return properties.getColumn();
    }
}
