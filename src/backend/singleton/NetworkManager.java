package backend.singleton;

public class NetworkManager {

    //escolhi deixar as nomenclaturas do projeto em inglês por conseguir ser mais sucinto
    private static final NetworkManager INSTANCIA = new NetworkManager();

    private String URL_BASE = "https://api.shopfacil.com";
    private int contadorRequisicoes;
    private int timeout; // seconds

    //contém timeout e requisições realizadas
    private NetworkManager(){
        setTimeout();
        this.contadorRequisicoes = getContadorRequisicoes();
    }

    //acesso
    public static NetworkManager getInstance(){
        return INSTANCIA;
    }

    //realiza conexão, gerando url completa e contador de requisições
    public void connect(String nome_servico){
        String full_URL = getBASE_URL() + "/" + nome_servico;
        contadorRequisicoes++;
    }

    public int getContadorRequisicoes() {
        return contadorRequisicoes;
    }

    //retorna quantidade de requisições realizadas
    public String getStats(){
        return "[SINGLETON] Requisições Realizadas: " + contadorRequisicoes + " | Timeout: " + getTimeout() + "s\n";
    }

    public String getBASE_URL() {
        return URL_BASE;
    }

    public void setTimeout(){
        this.timeout = 30;
    }

    public int getTimeout() {
        return timeout;
    }
}
