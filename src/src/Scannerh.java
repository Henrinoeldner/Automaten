import untils.List;

public class Scannerh {
    private boolean fehler;
    private String eingabe;
    private List<Token> tokenlist;
    private Token aktuellesToken;

    public Scannerh(String eingabe, List<Token> tokenlist) {
        this.eingabe = eingabe;
        this.tokenlist = tokenlist;
    }
    public void scanne(){
        for (int i=0;i<eingabe.length();i+=2){
            String speicher=eingabe.substring(i,i+2);
           if(speicher.equals("la")||speicher.equals("le")||speicher.equals("lu")){
               tokenlist.append(new Token(speicher, ""+(i+2)/2));
           }else{
               System.out.println("Das Element '"+speicher+"' an der Stelle "+(i+2)/2+" entspricht nicht dem berechtigen Eingabe Alphabet. Erwartet 'la','le' oder 'lu'");
               fehler=true;
               break;
           }
        }
        ausgbabe(fehler);
    }

    private void ausgbabe(boolean pFehler){
        if (pFehler){
            System.out.println("Das eingegebene Wort entspricht nicht dem Eingabe Alphabet");
        }else{
            System.out.println("Das eingegebene Wort entspricht dem Eingabe Alphabet");
        }

    }

    public List<Token> getTokenlist() {
        if(fehler){
            return null;
        }
        return tokenlist;
    }
}
