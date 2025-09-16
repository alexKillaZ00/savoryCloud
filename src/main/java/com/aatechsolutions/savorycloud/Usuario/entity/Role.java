package com.aatechsolutions.savorycloud.Usuario.entity;

public enum Role {
    ADMIN("Administrador"),
    CAJERO("Cajero"),
    MESERO("Mesero"),
    COCINERO("Cocinero"),
    REPARTIDOR("Repartidor"),
    LIMPIEZA("Limpieza");
    
    private final String displayName;
    
    Role(String displayName) {
        this.displayName = displayName;
    }
    
    public String getDisplayName() {
        return displayName;
    }
}