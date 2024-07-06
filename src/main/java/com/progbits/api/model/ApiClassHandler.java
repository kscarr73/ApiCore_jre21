package com.progbits.api.model;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.Map;

/**
 * Handle Class Implementations for ApiObject
 */
public class ApiClassHandler {
    public static Object classPut(ApiClass acls, Map<String, Object> fields, String name, Object value) {
        String type = acls.getString(
                "fields[name=" + name + "].type", "");

        switch (type) {
            case "String":
                if (value instanceof String) {
                    return fields.put(name, value);
                }
                if (value == null) {
                    return fields.put(name, null);
                } else {
                    return fields.put(name, String.valueOf(value));
                }

            case "Integer":
                if (value instanceof Integer) {
                    return fields.put(name, value);
                } else if (value instanceof Long) {
                    return fields.put(name, ((Long) value).intValue());
                } else if (value instanceof Double) {
                    return fields.put(name, ((Double) value).intValue());
                } else if (value instanceof String) {
                    if (((String) value).trim().isEmpty()) {
                        return fields.put(name, null);
                    } else {
                        return fields.put(name, Integer.parseInt((String) value));
                    }
                } else if (value instanceof BigDecimal) {
                    return fields.put(name, ((BigDecimal) value).intValue());
                } else {
                    return fields.put(name, value);
                }

            case "Long":
                if (value instanceof Long) {
                    return fields.put(name, value);
                } else if (value instanceof Integer) {
                    return fields.put(name, ((Integer) value).longValue());
                } else if (value instanceof Double) {
                    return fields.put(name, ((Double) value).longValue());
                } else if (value instanceof String) {
                    if (((String) value).trim().isEmpty()) {
                        return fields.put(name, null);
                    } else {
                        return fields.put(name, Long.parseLong((String) value));
                    }
                } else if (value instanceof BigDecimal) {
                    return fields.put(name, ((BigDecimal) value).longValue());
                } else {
                    return fields.put(name, value);
                }
            case "ArrayList":
                return fields.put(name, value);
            case "Object":
                return fields.put(name, value);
            case "DateTime":
                if (value instanceof String) {
                    if (((String) value).isEmpty()) {
                        return fields.put(name, null);
                    } else {
                        return fields.put(name, OffsetDateTime.parse((String) value));
                    }

                } else {
                    return fields.put(name, value);
                }
            case "Double":
                if (value instanceof Double) {
                    return fields.put(name, value);
                } else if (value instanceof Integer) {
                    return fields.put(name, ((Integer) value).doubleValue());
                } else if (value instanceof Long) {
                    return fields.put(name, ((Long) value).doubleValue());
                } else if (value instanceof String) {
                    if (((String) value).trim().isEmpty()) {
                        return fields.put(name, null);
                    } else {
                        return fields.put(name, Double.parseDouble((String) value));
                    }
                } else if (value instanceof BigDecimal) {
                    return fields.put(name, ((BigDecimal) value).doubleValue());
                } else {
                    return fields.put(name, value);
                }

            case "Decimal":
                if (value instanceof BigDecimal) {
                    return fields.put(name, value);
                } else if (value instanceof Integer) {
                    return fields.put(name, BigDecimal.valueOf((Integer) value).longValue());
                } else if (value instanceof Double) {
                    return fields.put(name, BigDecimal.valueOf((Double) value));
                } else if (value instanceof String) {
                    if (((String) value).trim().isEmpty()) {
                        return fields.put(name, null);
                    } else {
                        return fields.put(name, new BigDecimal((String) value));
                    }
                } else if (value instanceof Long) {
                    return fields.put(name, BigDecimal.valueOf((Long) value));
                } else {
                    return fields.put(name, value);
                }

            case "StringArray":
                return fields.put(name, value);

            case "IntegerArray":
                return fields.put(name, value);

            case "Boolean":
                if (value instanceof Boolean) {
                    return fields.put(name, value);
                } else if (value instanceof String) {
                    if (((String) value).trim().isEmpty()) {
                        return fields.put(name, null);
                    } else {
                        return fields.put(name, Boolean.parseBoolean((String) value));
                    }
                } else if (value instanceof Integer) {
                    if ((Integer) value != 0) {
                        return fields.put(name, Boolean.TRUE);
                    } else {
                        return fields.put(name, Boolean.FALSE);
                    }
                } else {
                    return fields.put(name, value);
                }

            default:
                return fields.put(name, value);
        }
    }

}
