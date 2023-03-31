package br.com.correiosconsultacep.model.enuns;

import lombok.NoArgsConstructor;

/**
 * Enum responsável por armazenar os valores de frete por estado, divididos por regiões.
 */
@NoArgsConstructor
public enum ValoresDeFretePorEstadoEnum {

    SAOPAULO("SP", "SUDESTE", "7.85"), MINASGERAIS("MG", "SUDESTE", "7.85"), ESPIRITOSANTO("ES", "SUDESTE", "7.85"), RIODEJANEIRO("RJ", "SUDESTE", "7.85"),
    RIOGRANDEDOSUL("RS", "SUL", "17.30"), SANTACATARINA("SC", "SUL", "17.30"), PARANA("PR", "SUL", "17.30"),
    MATOGROSSODOSUL("MS", "CENTRO-OESTE", "12.50"), GOIAS("GO", "CENTRO-OESTE", "12.50"), MATOGROSSO("MT", "CENTRO-OESTE", "12.50"), DISTRITOFEDERAL("DF", "CENTRO-OESTE", "12.50"),
    ACRE("AC", "NORTE", "20.83"), AMAZONAS("AM", "NORTE", "20.83"), RORAIMA("RR", "NORTE", "20.83"), PARA("PA", "NORTE", "20.83"), TOCANTINS("TO", "NORTE", "20.83"), AMAPA("AP", "NORTE", "20.83"), RONDONIA("RO", "NORTE", "20.83"),
    MARANHAO("MA", "NORDESTE", "15.98"), PIAUI("PI", "NORDESTE", "15.98"), BAHIA("BA", "NORDESTE", "15.98"), SERGIPE("SE", "NORDESTE", "15.98"), ALAGOAS("AL", "NORDESTE", "15.98"), PERNAMBUCO("PE", "NORDESTE", "15.98"), PARAIBA("PB", "NORDESTE", "15.98"), RIOGRANDEDONORTE("RN", "NORDESTE", "15.98"), CEARA("CE", "NORDESTE", "15.98"),
    ;

    private String nomeEstado;
    private String regiao;
    private String valorFrete;

    ValoresDeFretePorEstadoEnum(String nomeEstado, String regiao, String valorFrete) {
        this.nomeEstado = nomeEstado;
        this.regiao = regiao;
        this.valorFrete = valorFrete;
    }

    /**
     * Retorna o nome do estado.
     * @return O nome do estado.
     */
    @Override
    public String toString() {
        return this.nomeEstado;
    }

    /**
     * Encontra o valor do frete para um estado específico.
     * @param nomeEstado O nome do estado a ser encontrado.
     * @return O valor do frete para o estado encontrado ou IllegalArgumentException: caso o estado informado não seja encontrado na lista de valores de frete por estado..
     */
    public static String find(String nomeEstado) {
        for (ValoresDeFretePorEstadoEnum indicador : ValoresDeFretePorEstadoEnum.values()) {
            if (indicador.toString().equals(nomeEstado)) {
                return indicador.valorFrete;
            }
        }
        throw new IllegalArgumentException("Estado não encontrado na lista de valores de frete por estado");
    }

}
