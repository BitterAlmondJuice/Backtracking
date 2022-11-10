import java.util.Arrays;

public class ProblemaMaxSubconjuntoQueSuma0 {

    public boolean[] maxSubconjuntoQueSuma0(int[] vector) {
        boolean[] solucion = new boolean[vector.length];
        boolean[] mejorSolucion = new boolean[vector.length];
        for (int i = 0; i < solucion.length; i++) {
            solucion[i] = false;
            mejorSolucion[i] = false;
        }
        int numElem = 0;
        Entero mejorNumElem = new Entero(0);
        int acumulado = 0, nivel = 0;
        maxSubconjuntoQueSuma0Aux(vector, numElem, solucion, mejorNumElem, mejorSolucion, nivel, acumulado);
        return mejorSolucion;

    }

    void maxSubconjuntoQueSuma0Aux(int[] v, int numElem, boolean[] solucion, Entero mejorNumElem, boolean[] mejorSolucion, int nivel, int acumulado) {

        if (nivel == v.length) {
            if (acumulado == 0 && numElem > mejorNumElem.getValor()) {
                mejorNumElem.setValor(numElem);
                for (int i = 0; i < mejorSolucion.length; i++) {
                    mejorSolucion[i] = solucion[i];
                }
            }
        } else {

            int c = 0; // Candidatos: c=0 no añadir; c=1 añadir
            while (c < 2) {
                // dado que hay números positivos y negativos, siempre
                // es aceptable No añadirlo o añadirlo
                solucion[nivel] = (c == 1);
                acumulado += (v[nivel] * c);
                numElem += c;
                nivel += 1;
                maxSubconjuntoQueSuma0Aux(v, numElem, solucion, mejorNumElem, mejorSolucion, nivel, acumulado);
                nivel -= 1;
                numElem = numElem - c;
                acumulado = acumulado - (v[nivel] * c);
                solucion[nivel] = false;
                c++;

            }
        }
    }

    public static void main(String[] args) {
        ProblemaMaxSubconjuntoQueSuma0 main = new ProblemaMaxSubconjuntoQueSuma0();
        int[] vector = new int[]{1, 4, 6, -3};
        System.out.println(Arrays.toString(main.maxSubconjuntoQueSuma0(vector)));

    }
}


