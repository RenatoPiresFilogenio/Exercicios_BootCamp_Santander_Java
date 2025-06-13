package src;

public final class Iphone implements AparelhoTelefonico, NavegadorInternet, ReprodutorMusical {

    private boolean tocandoMusica = false;
    private String musica;
    private String numero;

    @Override
    public void tocar() {
        if (musica == null || musica.isEmpty()) {
            System.out.println("Não tem música para tocar");
            return;
        }
        System.out.println("Música tocando");
        this.tocandoMusica = true;
    }

    @Override
    public void pausar() {
        if (!tocandoMusica) {
            System.out.println("Não tem música tocando");
            return;
        }
        System.out.println("Música pausada");
        this.tocandoMusica = false;
    }

    @Override
    public void selecionarMusica(String musica) {
        System.out.println("Música selecionada: " + musica);
        this.musica = musica;
    }

    @Override
    public void ligar(String numero) {
        if (numero == null || numero.isEmpty()) {
            System.out.println("Não tem um número para ligar");
            return;
        }
        this.numero = numero;
        System.out.println("Ligando para " + numero);
    }

    @Override
    public void atender() {
        System.out.println("Você atende o telefone.");
    }

    @Override
    public void iniciarCorreioVoz() {
        if (numero == null || numero.isEmpty()) {
            System.out.println("Não tem um número para enviar correio");
            return;
        }
        System.out.println("Você enviou correio para " + numero);
    }

    @Override
    public void exibirPagina(String url) {
        System.out.println("Você acessou a url " + url);
    }

    @Override
    public void adicionarNovaAba() {
        
        System.out.println("Nova aba adicionada");
    }

    @Override
    public void atualizarPagina() {
        System.out.println("Página atualizada");
    }
}

