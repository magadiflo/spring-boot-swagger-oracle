package com.magadiflo.app.service;

import com.magadiflo.app.model.Participante;

import java.util.List;

public interface IParticipanteService {
    List<Participante> findParticipantes();

    Participante saveParticipante(Participante participante);
}
