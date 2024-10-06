package com.magadiflo.app.repository;

import com.magadiflo.app.model.Participante;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IParticipanteRepository extends JpaRepository<Participante, Long> {
}
