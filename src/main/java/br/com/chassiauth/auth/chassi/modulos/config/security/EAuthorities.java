package br.com.chassiauth.auth.chassi.modulos.config.security;

public enum EAuthorities {

    MANAGE_USERS("MANAGE_USERS"),
    USERS_TEST("USERS_TEST");

    private String description;

    private final String PREFIX_ROLE = "SCOPE_";

    private EAuthorities(String description){
        this.description = description;
    }

    public String getDescription() {
        return PREFIX_ROLE + description;
    }

    public String getSimpleDescription() {
        return description;
    }
}
