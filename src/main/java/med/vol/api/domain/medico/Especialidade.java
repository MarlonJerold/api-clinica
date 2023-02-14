package med.vol.api.domain.medico;

public enum Especialidade {

    ORTOPEDIA ("ORTOPEDIA"),
    CARDIOLOGIA ("CARDIOLOGIA"),
    GIONECOLOGISTA ("GIONECOLOGISTA"),
    DERMATOLOGISTA ("DERMATOLOGISTA");



    private final String esp;

    Especialidade(String esp){
        this.esp = esp;
    }
}
