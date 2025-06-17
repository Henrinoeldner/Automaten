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
            return pruefeA();
        }
        fehler=false;
        return false;
    }
    public boolean pruefeA(){
        if (tokenlist.getContent().getWert().equals("la")||tokenlist.getContent().getWert().equals("le")||tokenlist.getContent().getWert().equals("lu")){
            return pruefeB();
        }
        fehler=false;
        return false;
    }
    public boolean pruefeB(){
        if (tokenlist.getContent().getWert().equals("lu")&&nextToken()==null){
            return true;
        }
        fehler=false;
        return false;
    }
}
