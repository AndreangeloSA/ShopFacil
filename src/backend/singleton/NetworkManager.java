package backend.singleton;

public class NetworkManager {

    //escolhi deixar as nomenclaturas do projeto em inglês por conseguir ser mais sucinto
    private static final NetworkManager INSTANCE = new NetworkManager();

    private String BASE_URL = "https://api.shopfacil.com";
    private int requisitionCounter;
    private String service_name;
    private int timeout; // seconds

    //contém timeout e requisições realizadas
    private NetworkManager(){
        setTimeout();
        this.requisitionCounter = getRequisitionCounter();
    }

    //acesso
    public static NetworkManager getInstance(){
        return INSTANCE;
    }

    //realiza conexão, gerando url completa e contador de requisições
    public void connect(String service_name){
        String full_URL = getBASE_URL() + "/" + getService_name();
        requisitionCounter++;
    }

    public int getRequisitionCounter() {
        return requisitionCounter;
    }

    //retorna quantidade de requisições realizadas
    public String getStats(){
        return "[SINGLETON] Requisições Realizadas: " + requisitionCounter + " | Timeout: " + getTimeout() + "s\n";
    }

    public String getBASE_URL() {
        return BASE_URL;
    }

    public void setTimeout(){
        this.timeout = 30;
    }

    public int getTimeout() {
        return timeout;
    }

    public String getService_name() {
        return service_name;
    }
}
