package org.project.object;

import org.project.entity.Entity;

public interface gameObject {
    void use(Entity target);
    String getName();
}