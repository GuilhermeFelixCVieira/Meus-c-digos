import java.util.ArrayList;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Lutador l[] = new Lutador [6]; //Criei um array de 6 elementos
        l[0] = new Lutador("Pretty Boy", "França", 31, 68.9f,1.75f, 3, 11, 1);
        l[1] = new Lutador("Putscript", "Brasil", 29, 57.8f, 1.68f, 2, 14, 3);
        l[2] = new Lutador("Snapshadow", "EUA", 35, 88.9f, 1.65f, 2, 12, 1);
        l[3] = new Lutador("Dead Code", "Austrália", 28, 81.6f, 1.93f, 0, 13, 2);
        l[4] = new Lutador("Ufocobol", "Brasil", 37, 119.3f, 1.70f, 4, 5, 3);
        l[5] = new Lutador("Nerdaard", "EUA", 30, 105.7f, 1.81f, 2, 12, 4);

        luta UEC01 = new luta();
        UEC01.marcarLuta(l[0], l[1]);
        UEC01.lutar();

        l[0].status();
        l[1].status();
    }
}