package pl.walasiak.testing;

public class Account {

    private boolean Active;
    private Adress defoultDeliveryAdress;

    public Account(){
        this.Active = false;
    }

    public void activate(){
        this.Active = true;
    }

    public boolean isActive(){
        return this.Active;
    }

    public Adress getDefoultDeliveryAdress() {
        return defoultDeliveryAdress;
    }

    public void setDefoultDeliveryAdress(Adress defoultDeliveryAdress) {
        this.defoultDeliveryAdress = defoultDeliveryAdress;
    }
}
