package br.com.chassiauth.auth.chassi.modulos.config.security;

public enum ERoles {

    CADASTRAR_USUARIO("CADASTRAR_USUARIO");

    private String description;

    private final String PREFIX_ROLE = "ROLE_";

    private ERoles(String description){
        this.description = description;
    }

    public String getDescription() {
        return PREFIX_ROLE + description;
    }

    public String getSimpleDescription() {
        return description;
    }
}
