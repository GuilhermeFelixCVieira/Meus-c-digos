//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static BancoDePalavras banco = new BancoDePalavras();
    static String[][] categorias = {banco.animais, banco.lugares, banco.objetos};
    static String[] nomeCategoria ={"animal", "lugar", "objeto"};
    static int Vidas;
    static Set<Character> LetrasTestadas = new HashSet<>();//Usarei para impedir que o cara fique usando a mesma letra

    //  Tempo:
    public static void tempo(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {}
    }
    public static void main(String[] args) {
        //Início do jogo
        System.out.println("Bem vindo ao jogo da forca!");
        tempo(1000);
        while (true) {
            System.out.println("Você quer jogar na dificuldade fácil (7 vidas), média (5 vidas) ou difícil (3 vidas)?");
            String dificuldade = sc.nextLine().toLowerCase();
            tempo(1000);
            switch (dificuldade){
                case "facil":
                    Vidas = 7;
                    break;
                case "medio":
                case "media":
                    Vidas = 5;
                    break;
                case "dificil":
                    Vidas = 3;
                    break;
                default:
                    System.out.println("Resposta inválida!");
                    tempo(1000);
                    continue;
            }
            break;
        }
        System.out.println("Pressione Enter para iniciar.");
        sc.nextLine();
        Random r = new Random();
        int IndiceCategoria = r.nextInt(categorias.length); //Escolhe um índice aleatório (0, 1 ou 2)
                                                            //Já que 'categorias' tem 3 elementos.

        String[] CategoriaEscolhida = categorias[IndiceCategoria]; //'CategoriaEscolhida' é um array, que é o array
        //escolhido aleatoriamente dentro do array "categerias", por meio do "IndiceCategoria".
        //pode ser 'animais', 'objetos' ou 'lugares'. Agora, basta escolher a palavra da CategoriaEscolhida:

        //Sistema de dicas
        int IndicePalavra = r.nextInt(CategoriaEscolhida.length);
        String PalavraEscolhida = CategoriaEscolhida[IndicePalavra];
        int qtddLetras = PalavraEscolhida.length();
        char[] progresso = new char[qtddLetras];
        //progresso
        for (int i=0; i < qtddLetras; i++){
            progresso[i]='_';
        } tempo(1500);
        System.out.println("Dica: A palavra é um "+ nomeCategoria[IndiceCategoria]+" e tem "+ qtddLetras+" letras!");

        while (Vidas>0 && !String.valueOf(progresso).equals(PalavraEscolhida)) {
            for (char c : progresso) {
                System.out.print(c+" ");
            }
            System.out.println();
            tempo(1500);
            System.out.println("Você tem "+Vidas+" vidas. Escolha uma letra: ");
            String LetraEscolhida = sc.nextLine();
            if(LetraEscolhida.isEmpty()){
                System.out.println("Digite pelo menos uma letra!");
                continue;
            }

            char Letra = LetraEscolhida.charAt(0); //Esta linha e a anterior é pra caso o usuário coloque mais que
                                                    // uma letra, daí ele pega só a primeira. Ex: Plw --> P.
            Letra = Character.toLowerCase(Letra); //transforma a letra que ele colocou em minúscula.

            //Verificar se a Letra já foi testada antes (antes inclusive de adicioná-la no Set):
            if (LetrasTestadas.contains(Letra)){
                tempo(1000);
                System.out.println("Você já testou essa letra, escolha outra!");
                continue;
            }

            //Colocar a Letra no Set de Letras já testadas:
            LetrasTestadas.add(Letra);

            //Verificar se a letra aparece na palavra:

            boolean acertou = false;

            for (int i=0; i<PalavraEscolhida.length(); i++) {
                if (PalavraEscolhida.charAt(i)==Letra) {
                    progresso[i]=Letra;
                    acertou = true;
                }
            }
            if (!acertou) {
                tempo(1000);
                System.out.println("Errou!");
                Vidas --;
            } else {
                tempo(1000);
                System.out.println("Acertou!");
            }
            tempo (1500);
        }
        if (Vidas==0 && !String.valueOf(progresso).equals(PalavraEscolhida)){
            System.out.println("Sinto muito, você perdeu! \nA palavra era "+PalavraEscolhida);
        } else {
            System.out.println("Parabéns, você encontrou a palavra! "+PalavraEscolhida.toUpperCase(Locale.ROOT));
        }
    }
}