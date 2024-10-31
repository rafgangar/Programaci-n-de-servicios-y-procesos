class Corredor extends Thread {
    private final int id;
    private final Carril carril;
    private boolean tieneTestigo;

    public Corredor(int id, Carril carril) {
        this.id = id;
        this.carril = carril;
        this.tieneTestigo = id == 0; // Solo el primer corredor tiene el testigo al inicio
    }

    @Override
    public void run() {
        if (tieneTestigo) {
            System.out.println("Carril " + carril.getId() + " Corredor " + id + ": Tengo el testigo y empiezo a correr");
        }
        while (true) {
            if (tieneTestigo) {
                if (carril.avanzarCorredor(id)) {
                    System.out.println("Carril " + carril.getId() + " Corredor " + id + ": He terminado de correr. Posición final: " + carril.obtenerPosicion(id));
                    carril.corredorTermina();
                    break;
                }
            } else {
                Corredor siguienteCorredor = carril.puedePasarTestigo(id);
                if (siguienteCorredor != null) {
                    siguienteCorredor.recibirTestigo();
                    System.out.println("Carril " + carril.getId() + " Corredor " + (id + 1) + ": Recibo el testigo");
                    break;
                }
            }
        }
    }

    public void recibirTestigo() {
        tieneTestigo = true;
    }

    public long getId() {
        return id;
    }
}
