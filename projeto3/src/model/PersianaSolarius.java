package model;

public class PersianaSolarius {
    private boolean aberta;

    public void subirPersiana() {
        aberta = true;
    }
    public void descerPersiana() {
        aberta = false;
    }

    public boolean estaAberta() {
        return aberta;
    }

}

