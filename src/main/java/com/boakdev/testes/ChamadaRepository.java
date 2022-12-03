package com.boakdev.testes;

import java.util.ArrayList;
import java.util.List;

public class ChamadaRepository {

    List<Chamada> chamadas = new ArrayList<>();

    public Chamada salvar(Chamada chamada){
        chamadas.add(chamada);
        return chamada;
    }
}
