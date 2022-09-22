package br.com.anderson.bravi.teste.testebravi.vo;

import lombok.Data;

import java.util.List;

@Data
public class ClimaCidadeVO {

    private String name;
    private List<TempoVO> weather;

}
