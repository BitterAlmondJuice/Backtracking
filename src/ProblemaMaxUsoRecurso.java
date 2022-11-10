public class ProblemaMaxUsoRecurso {

    boolean[] maxUsoRecurso(int[] comienzo, int[] fin) {
        boolean[] seleccionados = new boolean[comienzo.length];
        int usoRecurso = 0;
        boolean[] mejorSeleccionados = new boolean[comienzo.length];
        Entero mejorUsoRecurso = new Entero(0);
        for (int i = 0; i < seleccionados.length; i++) {
            seleccionados[i] = false;
        }
        maxUsoRecursoAux(comienzo, fin, 0, seleccionados, usoRecurso, mejorSeleccionados, mejorUsoRecurso);
        return mejorSeleccionados;
    }

    void maxUsoRecursoAux(int[] comienzo, int[] fin, int tarea, boolean[] seleccionados, int usoRecurso, boolean[] mejorSeleccionados, Entero mejorUsoRecurso) {
        if (tarea == comienzo.length) {
            if (usoRecurso > mejorUsoRecurso.getValor()) {
                mejorUsoRecurso.setValor(usoRecurso);
                for (int i = 0; i < usoRecurso; i++) {
                    mejorSeleccionados[i] = seleccionados[i];
                }
            }
        } else {
            int c = 0;
            while (c < 2) {
                if ((c == 0) || compatible(comienzo, fin, seleccionados, tarea)) {
                    seleccionados[tarea] = (c == 1);
                    usoRecurso = usoRecurso + (fin[tarea] - comienzo[tarea]) * c;
                    tarea++;
                    maxUsoRecursoAux(comienzo, fin, tarea, seleccionados, usoRecurso,
                            mejorSeleccionados, mejorUsoRecurso);
                    tarea--;
                    usoRecurso = usoRecurso - (fin[tarea] - comienzo[tarea]) * c;
                    seleccionados[tarea] = false;
                }
                c++;
            }
        }


    }

    boolean compatible(int[] comienzo, int[] fin, boolean[] seleccionados, int tarea) {
        boolean ok = true;
        int i = 0;
        while (ok && (i < tarea)) {
            if (seleccionados[i])
                ok = ((comienzo[i] >= fin[tarea]) || (comienzo[tarea] >= fin[i]));
            i++;
        }
        return ok;
    }
}
