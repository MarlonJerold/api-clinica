package med.vol.api.domain.medico;

public enum Specialty {

    ORTOPEDIA ("ORTOPEDIA"),
    CARDIOLOGIA ("CARDIOLOGIA"),
    GIONECOLOGISTA ("GIONECOLOGISTA"),
    DERMATOLOGISTA ("DERMATOLOGISTA");



    private final String esp;

    Specialty(String esp){
        this.esp = esp;
    }
}
