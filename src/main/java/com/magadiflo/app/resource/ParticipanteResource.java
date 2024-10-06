package com.magadiflo.app.resource;

import com.magadiflo.app.model.Participante;
import com.magadiflo.app.service.IParticipanteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ParticipanteResource {

    private final IParticipanteService participanteService;

    public ParticipanteResource(IParticipanteService participanteService) {
        this.participanteService = participanteService;
    }

    @GetMapping("/participantes")
    public List<Participante> listarParticipantes() {
        return this.participanteService.findParticipantes();
    }

    @PostMapping("/participantes")
    public Participante registrarParticipante(@RequestBody Participante participante) {
        return this.participanteService.saveParticipante(participante);
    }

}
