import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

class Carril {
    private final int id;
    private ConcurrentHashMap<Integer, Corredor> corredores;
    private final AtomicInteger posiciones;

    public Carril(int id) {
        this.id = id;
        this.corredores = new ConcurrentHashMap<>();
        this.posiciones = new AtomicInteger(0);
    }

    public boolean añadirCorredor(Corredor corredor, int posicion) {
        if (posicion < 0 || posicion >= 400000) return false;
        return corredores.putIfAbsent(posicion, corredor) == null;
    }

    public boolean avanzarCorredor(int idCorredor) {
        if (corredores == null) {
            corredores = new ConcurrentHashMap<>();
        }
        for (int i = 0; i < 400000; i++) {
            if (corredores.containsKey(i) && corredores.get(i).getId() == idCorredor) {
                if (!corredores.containsKey(i + 1) && i < 399999) {
                    corredores.put(i + 1, corredores.get(i));
                    corredores.remove(i);

                    return true;
                }
            }
        }
        return false;
    }

    public Corredor puedePasarTestigo(int idCorredor) {
        for (int i = 0; i < 400000; i++) {
            if (corredores.containsKey(i) && corredores.get(i).getId() == idCorredor) {
                return corredores.get(i + 1);
            }
        }
        return null;
    }

    public int obtenerPosicion(int idCorredor) {
        for (int i = 0; i < 400000; i++) {
            if (corredores.containsKey(i) && corredores.get(i).getId() == idCorredor) {
                return i;
            }
        }
        return -1;
    }

    public void corredorTermina() {
        posiciones.incrementAndGet();
        if (posiciones.get() == 4) {
            System.out.println("Carril " + id + " ha finalizado la carrera. Notificamos a hilo principal.");
        }
    }

    public int getId() {
        return id;
    }
}
