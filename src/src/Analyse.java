import untils.*;
import java.util.Scanner;

public class Analyse {
    private String eingabe;
    private List<Token> tokenliste;
    private Scannerh scanner;
    private Parser parser;
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while (true){
            System.out.println("Welches Wort möchtest du Analysieren?");
            new Analyse(scanner.next());
        }


    }

    public Analyse(String eingabe) {
        this.eingabe = eingabe;
        tokenliste=new List<>();
        scanner=new Scannerh(eingabe,tokenliste);
        parser=new Parser(tokenliste);
        analysiere();
    }
    public void analysiere(){
        scanner.scanne();
        tokenliste=scanner.getTokenlist();
        if (tokenliste!=null){
            parser.parse();
        }
    }
}