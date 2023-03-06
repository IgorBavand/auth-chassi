package br.com.chassiauth.auth.chassi.modules.users.enums;

public enum ESituation {
    ACTIVE("A"),
    INACTIVE("I");

    private String response;

    ESituation(String response) {
        this.response = response;
    }

    public String getBoolean() {
        return response;
    }
}
