package com.boakdev.testes;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

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

        Chamada outraChamada = new Chamada();
        outraChamada.setAluno(aluno);
        outraChamada.setPresente(true);
        outraChamada.setData(LocalDate.now());

        Mockito.when(chamadaRepository.salvar(chamada)).thenReturn(outraChamada);

        Chamada resultado = responderChamadaService.apply(chamada);

        Assertions.assertEquals(resultado.getData(), outraChamada.getData());
    }
}
