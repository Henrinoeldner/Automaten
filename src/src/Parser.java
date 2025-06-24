import untils.List;

public class Parser {
    private boolean fehler;
    private List<Token> tokenlist;
    private Token aktuellesToken;

    public Parser(List<Token> tokenlist) {
        this.tokenlist = tokenlist;
    }

    public Token nextToken(){
        Token s=tokenlist.getContent();
        tokenlist.next();
        Token ausgabe;
        if (tokenlist.hasAccess()) {
             ausgabe = tokenlist.getContent();
        }else{
             ausgabe = null;
        }
        tokenlist.toFirst();
        while (tokenlist.getContent()!=s){
            tokenlist.next();
        }
        return ausgabe;
    }
    public boolean parse(){
        tokenlist.toFirst();
        return pruefeS();
    }

    public boolean pruefeS(){
        if (tokenlist.getContent().getWert().equals("la")||tokenlist.getContent().getWert().equals("le")||tokenlist.getContent().getWert().equals("lu")){
            tokenlist.next();
            return pruefeA();
        }
        System.out.println("Das Element '"+ tokenlist.getContent().getWert()+"' an der Stelle "+tokenlist.getContent().getTyp()+" ist nicht korrekt. Erwartet 'la','le' oder 'lu'");
        fehler=false;
        return false;
    }
    public boolean pruefeA(){
        if (tokenlist.getContent().getWert().equals("la")||tokenlist.getContent().getWert().equals("le")||tokenlist.getContent().getWert().equals("lu")){
            tokenlist.next();
            return pruefeB();
        }
        System.out.println("Das Element '"+ tokenlist.getContent().getWert()+"' an der Stelle "+tokenlist.getContent().getTyp()+" ist nicht korrekt. Erwartet 'la','le' oder 'lu'");
        fehler=false;
        return false;
    }


    public boolean pruefeB(){
        if (tokenlist.getContent().getWert().equals("lu") && this.nextToken()==null){
            return true;
        }
        if (!tokenlist.getContent().getWert().equals("lu")){
            System.out.println("Das Element '" + tokenlist.getContent().getWert() + "' an der Stelle " + tokenlist.getContent().getTyp() + " ist nicht korrekt. Erwartet 'lu'");
        }else{
            System.out.println("Das Element '" + nextToken().getWert() + "' an der Stelle 4 ist nicht korrekt. Erwartet null");
        }
        fehler=false;
        return false;
    }
}
