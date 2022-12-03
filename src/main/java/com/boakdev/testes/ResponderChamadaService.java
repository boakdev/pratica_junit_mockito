package com.boakdev.testes;

public class ResponderChamadaService {

    private ChamadaRepository chamadaRepository;

    public ResponderChamadaService(ChamadaRepository chamadaRepository) {
        this.chamadaRepository = chamadaRepository;
    }

    public Chamada apply(Chamada chamada) throws ValidacaoException {
        chamada.getAluno().verificaAlunoMatriculado();
       return chamadaRepository.salvar(chamada);
     }
}
