package com.magadiflo.app.service;

import com.magadiflo.app.model.Participante;
import com.magadiflo.app.repository.IParticipanteRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ParticipanteServiceImpl implements IParticipanteService {

    private final IParticipanteRepository participanteRepository;

    public ParticipanteServiceImpl(IParticipanteRepository participanteRepository) {
        this.participanteRepository = participanteRepository;
    }

    @Override
    public List<Participante> findParticipantes() {
        return this.participanteRepository.findAll();
    }

    @Override
    public Participante saveParticipante(Participante participante) {
        return this.participanteRepository.save(participante);
    }

}
