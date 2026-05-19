package backend.facade;

import java.util.HashMap;
import java.util.Random;

public class NotaFiscalService {

    public String emitirNotaFiscal(HashMap pedido1){
        Random random = new Random();

        int num_NF = random.nextInt(10000, 99999);
        return ("    [NF]      Nota fiscal emitida - NF-2026-" + num_NF);
    }
}
