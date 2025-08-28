package model;


public class PersianaNatLight {
    private boolean palhetaAberta;
    private boolean palhetaErguida;

    public void descerPalheta() {
        palhetaErguida = false;    
    }

    public void subirPalheta() {
        palhetaErguida = true;
    }

    public void abrirPalheta() {
        palhetaAberta = true;
    }

    public void fecharPalheta() {
        palhetaAberta = false;
    }

    public boolean estaPalhetaAberta() {
        return palhetaAberta;
    }

    public boolean estaPalhetaErguida() {
        return palhetaErguida;
    }
}
