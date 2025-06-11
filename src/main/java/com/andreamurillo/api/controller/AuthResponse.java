package com.andreamurillo.api.controller;

public class AuthResponse {
    private String mensaje;
    private Long usuarioId;

    public AuthResponse(String mensaje, Long usuarioId) {
        this.mensaje = mensaje;
        this.usuarioId = usuarioId;
    }

    public String getMensaje() { return mensaje; }
    public Long getUsuarioId() { return usuarioId; }
}

