public class Token {
    private String wert;
    private String typ;

    public Token(String wert, String typ) {
        this.wert = wert;
        this.typ = typ;
    }

    public String getWert() {
        return wert;
    }

    public void setWert(String wert) {
        this.wert = wert;
    }

    public String getTyp() {
        return typ;
    }

    public void setTyp(String typ) {
        this.typ = typ;
    }
}
