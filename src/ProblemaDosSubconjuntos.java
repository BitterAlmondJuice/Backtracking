import com.sun.tools.javac.Main;

public class ProblemaDosSubconjuntos {

    boolean hayDosSubconjuntos(int[] vector, int objetivo) {
        Booleano exito = new Booleano(false);
        int total = 0;
        for (int i = 0; i < vector.length; i++) {
            total += vector[i];
        }
        if (total / 2 >= objetivo) {
            hayDosSubconjuntosAux(vector, objetivo, 0, 0, 0, exito);
        }
        return exito.getValor();
    }

    void hayDosSubconjuntosAux(int[] vector, int vObjetivo, int elementoDelArray, int acumA, int acumB, Booleano exito) {
        if (acumA == vObjetivo && acumB == vObjetivo) {
            exito.setValor(true);
        } else if (elementoDelArray < vector.length) {
            int profundidad = 0;
            while (profundidad < 3 && !exito.getValor()) {
                if (profundidad == 0 || ((profundidad == 1) && acumA + vector[elementoDelArray] <= vObjetivo) || ((profundidad == 2) && acumB + vector[elementoDelArray] <= vObjetivo)) {
                    if (profundidad == 1) {
                        acumA += vector[elementoDelArray];
                    } else if (profundidad == 2) {
                        acumB += vector[elementoDelArray];
                    }
                    elementoDelArray++;
                    hayDosSubconjuntosAux(vector, vObjetivo, elementoDelArray, acumA, acumB, exito);
                    if (!exito.getValor()) {
                        elementoDelArray--;
                        if (profundidad == 1) {
                            acumA -= vector[elementoDelArray];
                        } else if (profundidad == 2) {
                            acumB -= vector[elementoDelArray];
                        }
                    }
                }
                profundidad++;
            }
        }

    }

    public static void main(String[] args) {
        ProblemaDosSubconjuntos main = new ProblemaDosSubconjuntos();
        int[] vector = new int[]{4, 2, 5, 5, 1, 8};
        System.out.println("hay dos subconjuntos?: " + main.hayDosSubconjuntos(vector, 10));
    }

}
