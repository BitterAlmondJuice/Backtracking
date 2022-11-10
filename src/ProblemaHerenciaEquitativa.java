public class ProblemaHerenciaEquitativa {


    boolean hayRepartoEquitativo(int[] bienes) {
        Booleano exito = new Booleano(false);
        int suma = 0;
        for (int i = 0; i < bienes.length; i++) {
            suma = suma + bienes[i];
        }
        if (suma % 3 == 0) { //podemos saber de antemano que no es posible el reparto equitativo
            int[] falta = {suma / 3, suma / 3, suma / 3};//se inicializa el array de lo que le fanta a cada uno, que al ser un reparto equitativo implica que cada uno debera tener un tercio del total
            hayRepartoEquitativoAux(bienes, 0, falta, exito);//llamada a la funcion auxiliar
        }
        return exito.getValor();
    }

    void hayRepartoEquitativoAux(int[] bienes, int elementosDelVEctor, int[] falta, Booleano exito) {
        if (elementosDelVEctor == bienes.length) {
            if (falta[0] == falta[1] && falta[1] == falta[2]) exito.setValor(true);
        } else {
            int c = 0;
            while ((c < 3) && !exito.getValor()) {
                if (bienes[elementosDelVEctor] <= falta[c]) { //si
                    falta[c] = falta[c] - bienes[elementosDelVEctor];
                    elementosDelVEctor++;
                    System.out.println("Cuanto le falta a cada uno: Persona 1 = " + falta[0] + " Persona 2 = " + falta[1] + " Persona 3 = " + falta[2]);
                    System.out.println("valor elementosDelVEctor antes de ver si hay exito: " + elementosDelVEctor);
                    hayRepartoEquitativoAux(bienes, elementosDelVEctor, falta, exito);
                    if (!exito.getValor()) {
                        elementosDelVEctor--;
                        System.out.println("valor elementosDelVEctor despues de ver si hay exito: " + elementosDelVEctor);
                        falta[c] = falta[c] + bienes[elementosDelVEctor];//
                    }
                }
                c++;
            }
        }
    }

    public static void main(String[] args) {
        int[] bienes = new int[]{1, 2, 3, 4, 5};
        ProblemaHerenciaEquitativa main = new ProblemaHerenciaEquitativa();
        System.out.println("Hay reparto equitativo?: " + main.hayRepartoEquitativo(bienes));

    }
}