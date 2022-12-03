package com.boakdev.testes;

public class ResponderChamadaService {

    private ChamadaRepository chamadaRepository;

    public ResponderChamadaService(ChamadaRepository chamadaRepository) {
        this.chamadaRepository = chamadaRepository;
    }

    public Chamada apply(Chamada chamada) {
       return chamadaRepository.salvar(chamada);
     }
}
