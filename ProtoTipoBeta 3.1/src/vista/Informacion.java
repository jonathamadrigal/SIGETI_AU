package vista;

public class Informacion {//clase para poder asignar la imagen diferente y un nombre a los arboles

    public Informacion(String name, String flagIcon) {
        this.name = name;
        this.flagIcon = flagIcon;
    }//----------------------------------------------------------------------------- FIN Constructor()

    public String getName() {
        return name;
    }//----------------------------------------------------------------------------- FIN getName()

    public void setName(String name) {
        this.name = name;
    }//----------------------------------------------------------------------------- FIN setName()

    public String getFlagIcon() {
        return flagIcon;
    }//----------------------------------------------------------------------------- FIN getFlagIcon()

    public void setFlagIcon(String flagIcon) {
        this.flagIcon = flagIcon;
    }//----------------------------------------------------------------------------- FIN setFlagIcon()

    @Override
    public String toString() {
        return getName();
    }//----------------------------------------------------------------------------- FIN toString()

    //Declaracion de variables
    private String name;
    private String flagIcon;
}//____________________________________________________________________END_CLASS
