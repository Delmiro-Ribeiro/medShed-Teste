package com.medShed.medShdTest.entities.enums;

public enum StatusServico {

    PENDENTE(1),
    CONFIRMADO(2),
    CANCELADO_CLIENTE(3),
    CANCELADO_PROFISSIONAL(4),
    REAGENDADO(5),
    CONCLUIDO(6);


    private int code;

    StatusServico(int code){
        this.code = code;
    }

    public int getCode(){
        return code;
    }


    public static StatusServico valueOf(int code){
        for (StatusServico value : StatusServico.values()){
            if (value.getCode() == code){
                return value;
            }
        }
        throw new IllegalArgumentException("Código de status inválido!");
    }

}
