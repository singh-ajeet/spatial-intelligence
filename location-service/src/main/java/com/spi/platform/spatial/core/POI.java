package com.si.platform.spatial.core;

import org.locationtech.jts.geom.Point;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * This class represents a location aware point of interest,
 * it can be an airport, a retail store etc
 */
public final class POI implements Serializable {
    private final Point location;
    private final Map<String, Object> attributes = new HashMap<>();

    public POI(Point location, Map<String, Object> attributes) {
        this.location = location;
        this.attributes.putAll(attributes);
    }

    public Point getLocation() {
        return location;
    }

    public Map<String, Object> getAttributes() {
        return attributes;
    }

    public Object getAttribute(String key){
        return attributes.get(key);
    }

    public void addAttribute(String key, Object value) {
        attributes.put(key, value);
    }
}
