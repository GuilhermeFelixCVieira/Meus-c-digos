public class Lutador {
    //Atributos do lutador
    private String nome; //pode fazer private String nome, nacionaldade, categioria;
    private String nacionalidade;
    private int idade;
    private float altura;
    private float peso;
    private String categoria;
    private int derrotas;
    private int vitorias;
    private int empates;

    //Metodos do lutador
    public void apresentar(){
        System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
        System.out.println("Apresentamos "+nome);
        System.out.println("Direttamente de "+nacionalidade);
        System.out.println(getIdade()+" anos");
        System.out.println(altura+" metros de altura");
        System.out.println("pesando "+peso+" kilos!");
    };
    public void status(){
        System.out.println(getNome() + " é um peso " + getCategoria());
        System.out.println("Até hoje, teve "+vitorias+" vitórias, "+derrotas+" derrotas e "+empates+" empates!");

    }
    public void ganharLuta(){

        setVitorias(getVitorias()+1);
    }
    public void perderLuta(){

        setDerrotas(getDerrotas()+1);
    }
    public void empatarLuta(){

        setEmpates(getEmpates()+1);
    }

    //Construtor
    public Lutador(String no, String na, int id, float pe, float al, int de, int vi, int em) {
        nome = no;
        nacionalidade = na;
        idade = id;
        setPeso(pe);
        altura = al;
        derrotas = de;
        vitorias = vi;
        empates = em;
    }

    //getters & setters

    public int getEmpates() {
        return empates;
    }

    public void setEmpates(int empates) {
        this.empates = empates;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String no) {
        this.nome = no;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int id) {
        this.idade = id;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String na) {
        this.nacionalidade = na;
    }

    public float getAltura() {
        return altura;
    }

    public void setAltura(float al) {
        this.altura = al;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float pe) {
        peso = pe;
        setCategoria();
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria() {
        if(peso<52.2) {
            categoria = "Inválido";
        } else if (peso <=70.3) {
            categoria = "leve";
        } else if (peso<=83.9){
            categoria = "Médio";
        } else if (peso<=120.2){
            categoria = "pesado";
        } else {
            categoria = "inválido";
        }
    }

    public int getDerrotas() {
        return derrotas;
    }

    public void setDerrotas(int de) {
        this.derrotas = de;
    }

    public int getVitorias() {
        return vitorias;
    }

    public void setVitorias(int vi) {
        this.vitorias = vi;
    }
}
