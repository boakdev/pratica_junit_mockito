package com.boakdev.testes;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.time.LocalDate;

public class ResponderChamadaServiceTest extends TestBase {


    @InjectMocks
    ResponderChamadaService responderChamadaService;

    @Mock
    ChamadaRepository chamadaRepository;

    @Test
    void salvarChamada(){
        Aluno aluno = new Aluno();
        aluno.setNome("Bruno Carvalho");

        Chamada chamada = new Chamada();
        chamada.setAluno(aluno);
        chamada.setPresente(true);
        chamada.setData(LocalDate.now());

        responderChamadaService.apply(chamada);
    }
}
