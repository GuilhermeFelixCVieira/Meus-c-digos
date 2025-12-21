import java.util.Random;

public class luta {
    //Atributos
    private Lutador desafiante; //agregação
    private Lutador desafiado; //agregação. A classe X tem um atributo da classe Y.
    private int round;
    private boolean aprovada; //pra saber se a luta poderá ser realizada

    //Metodos publicos
    public void marcarLuta(Lutador l1, Lutador l2){
        if (l1.getCategoria().equals(l2.getCategoria()) && l1 != l2){
            setAprovada(true);
            System.out.println("Luta aprovada!");
            desafiante = l1;
            desafiado = l2;
        } else {
            setAprovada(false);
            System.out.println("A luta não pode ocorrer!");
            desafiante = null;
            desafiado = null;
        }
    }
    public void lutar(){
        if (aprovada) {
            System.out.println("#DESAFIADO#");
            desafiado.apresentar();
            desafiado.status();
            System.out.println("Do outro ladooo!");
            System.out.println("#DESAFIANTE#");
            desafiante.apresentar();
            desafiante.status();
            Random aleatorio = new Random();
            System.out.println("=====LUTA=====");
            int vencedor = aleatorio.nextInt(3); //0, 1 e 2
            switch (vencedor){
                case 0: //Empate
                    System.out.println("Empate!");
                    desafiado.empatarLuta();
                    desafiante.empatarLuta();
                    break;
                case 1: //Desafiante vence
                    System.out.println("Vitória do "+ this.desafiante.getNome());
                    desafiante.ganharLuta();
                    desafiado.perderLuta();
                    break;
                case 2: //Desafiado vence
                    System.out.println("Vitória do "+ this.desafiado.getNome());
                    desafiado.ganharLuta();
                    desafiante.perderLuta();
            }
            System.out.println("=====FIM DA LUTA=====");
        }
    }

    //Metodos especiais


    public Lutador getDesafiante() {
        return desafiante;
    }

    public void setDesafiante(Lutador dt) {
        this.desafiante = dt;
    }

    public Lutador getDesafiado() {
        return desafiado;
    }

    public void setDesafiado(Lutador dd) {
        this.desafiado = dd;
    }

    public int getRound() {
        return round;
    }

    public void setRound(int r) {
        this.round = r;
    }

    public boolean isAprovada() {
        return aprovada;
    }

    public void setAprovada(boolean ap) {
        this.aprovada = ap;
    }
}
