package com.boakdev.testes;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.time.LocalDate;

public class ResponderChamadaServiceTest extends TestBase {

    Chamada chamada;
    Chamada outraChamada;
    Aluno aluno;

    @InjectMocks
    ResponderChamadaService responderChamadaService;

    @BeforeEach
    void setUp() {
        aluno = new Aluno();
        aluno.setNome("Bruno Carvalho");
        aluno.setStatusMatricula(true);

        chamada = new Chamada();
        chamada.setAluno(aluno);
        chamada.setPresente(true);
        chamada.setData(LocalDate.now());

        outraChamada = new Chamada();
        outraChamada.setAluno(aluno);
        outraChamada.setPresente(true);
        outraChamada.setData(LocalDate.now());
    }

    @Mock
    ChamadaRepository chamadaRepository;

    @Test
    void salvarChamada() throws ValidacaoException {
        Mockito.when(chamadaRepository.salvar(chamada)).thenReturn(outraChamada);
        Chamada resultado = responderChamadaService.apply(chamada);
        Mockito.verify(chamadaRepository).salvar(chamada);
        Assertions.assertEquals(resultado.getData(), outraChamada.getData());
    }


    @Test
    void verificaAlunoNaoMatriculado() {
        chamada.getAluno().setStatusMatricula(false);
        ValidacaoException validacao = Assertions.assertThrows(
                ValidacaoException.class,
                () -> responderChamadaService.apply(chamada));

        Assertions.assertEquals("Aluno não matriculado!", validacao.getMessage());
    }
}
