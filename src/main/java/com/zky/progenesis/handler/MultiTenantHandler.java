package com.zky.progenesis.handler;

import java.util.List;

import com.baomidou.mybatisplus.extension.plugins.handler.TenantLineHandler;
import com.zky.progenesis.config.MyContextHandler;
import com.zky.progenesis.config.properties.TenantProperties;

import net.sf.jsqlparser.expression.Expression;
import net.sf.jsqlparser.expression.StringValue;
import net.sf.jsqlparser.schema.Column;

public class MultiTenantHandler implements TenantLineHandler {

    private final TenantProperties properties;

    public MultiTenantHandler(TenantProperties properties) {
        this.properties = properties;
    }

    @Override
    public Expression getTenantId() {
        String tenantId = MyContextHandler.getTenantId();
        return new StringValue(tenantId);
    }
    
    @Override
    public String getTenantIdColumn() {
        return properties.getColumn();
    }

    @Override
    public boolean ignoreTable(String tableName) {
        if (properties.getFilterTables() != null) {
            return !properties.getFilterTables().contains(tableName);
        }
        return true;
    }

    @Override
    public boolean ignoreInsert(List<Column> columns, String tenantIdColumn) {
        return true;
    }
}
