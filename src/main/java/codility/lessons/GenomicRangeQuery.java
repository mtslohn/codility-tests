package codility.lessons;

import java.util.Arrays;

public class GenomicRangeQuery {

    // 'A' 'C' 'G' 'T';
    public int[] solution(String S, int[] P, int[] Q) {
        int[] menorInt = new int[P.length];

        for (int i = 0; i < P.length; i++) {

            char menorAtual = 'T';

            for (int j = P[i]; j <= Q[i]; j++) {
                char atual = S.charAt(j);
                if (atual < menorAtual) {
                    menorAtual = atual;
                    if (menorAtual == 'A') {
                        break;
                    }
                }
            }

            switch (menorAtual) {
                case 'A':
                    menorInt[i] = 1;
                    break;
                case 'C':
                    menorInt[i] = 2;
                    break;
                case 'G':
                    menorInt[i] = 3;
                    break;
                case 'T':
                    menorInt[i] = 4;
                    break;
            }

        }

        return menorInt;

    }

    // 'A' 'C' 'G' 'T';
    public int[] solutionB(String S, int[] P, int[] Q) {
        char[] menorChar = new char[P.length];
        int[] menorInt = new int[P.length];

        for (int i = 0; i < P.length; i++) {

            char menorAtual = 'T';

            int j = P[i];
            while (j <= Q[i]) {
                boolean found = false;

                for (int k = 0; k < i - 1; k++) {
                    if (j >= P[k] && j <= Q[k] && P[i] <= P[k] && Q[i] >= Q[k]) {
                        found = true;
                        j = Q[k] + 1;
                        if (menorChar[k] < menorAtual) {
                            menorAtual = menorChar[k];
                        }
                    }
                }

                if (!found) {
                    char atual = S.charAt(j);
                    if (atual < menorAtual) {
                        menorAtual = atual;
                        if (menorAtual == 'A') {
                            break;
                        }
                    }
                    j++;
                }
            }

            menorChar[i] = menorAtual;
        }

        for (int i = 0; i < P.length; i++) {
            switch (menorChar[i]) {
                case 'A':
                    menorInt[i] = 1;
                    break;
                case 'C':
                    menorInt[i] = 2;
                    break;
                case 'G':
                    menorInt[i] = 3;
                    break;
                case 'T':
                    menorInt[i] = 4;
                    break;
            }
        }

        return menorInt;

    }

    public int[] solutionFast(String S, int[] P, int[] Q) {

        int[] positions = new int[P.length];
        for (int index = 0; index < P.length; index++) {
            positions[index] = index;
        }



        char[] menorChar = new char[P.length];
        int[] menorInt = new int[P.length];

        for (int i = 0; i < P.length; i++) {

            char menorAtual = 'T';

            int j = P[i];
            while (j <= Q[i]) {
                boolean found = false;

                for (int k = 0; k < i - 1; k++) {
                    if (j >= P[k] && j <= Q[k] && P[i] <= P[k] && Q[i] >= Q[k]) {
                        found = true;
                        j = Q[k] + 1;
                        if (menorChar[k] < menorAtual) {
                            menorAtual = menorChar[k];
                        }
                    }
                }

                if (!found) {
                    char atual = S.charAt(j);
                    if (atual < menorAtual) {
                        menorAtual = atual;
                        if (menorAtual == 'A') {
                            break;
                        }
                    }
                    j++;
                }
            }

            menorChar[i] = menorAtual;
        }

        for (int i = 0; i < P.length; i++) {
            switch (menorChar[i]) {
                case 'A':
                    menorInt[i] = 1;
                    break;
                case 'C':
                    menorInt[i] = 2;
                    break;
                case 'G':
                    menorInt[i] = 3;
                    break;
                case 'T':
                    menorInt[i] = 4;
                    break;
            }
        }

        return menorInt;

    }

    // 'A' 'C' 'G' 'T';
    public int[] solutionPrefixSum(String S, int[] P, int[] Q) {
        int[][] prefixSums = new int[S.length() + 1][3];

        // primeira linha, aqui não foi lido nada ainda (para facilitar as contas depois)
        prefixSums[0] = new int[3];

        for (int i = 0; i < S.length(); i++) {
            prefixSums[i + 1] = prefixSums[i].clone();
            atualizaLinha(prefixSums[i + 1], S.charAt(i));
        }

        // somas prefixadas prontas, hora de caçar as respostas

        int[] solutions = new int[P.length];

        for (int i = 0; i < P.length; i++) {
            int inicioIntervalo = P[i] + 1;
            int fimIntervalo = Q[i] + 1;

            if (prefixSums[fimIntervalo][0] - prefixSums[inicioIntervalo - 1][0] > 0) {
                solutions[i] = decode('A');
            } else if (prefixSums[fimIntervalo][1] - prefixSums[inicioIntervalo - 1][1] > 0) {
                solutions[i] = decode('C');
            } else if (prefixSums[fimIntervalo][2] - prefixSums[inicioIntervalo - 1][2] > 0) {
                solutions[i] = decode('G');
            } else {
                solutions[i] = decode('T');
            }

        }

        return solutions;
    }

    public int decode(char letra) {
        switch (letra) {
            case 'A': return 1;
            case 'C': return 2;
            case 'G': return 3;
            case 'T': return 4;
        }
        throw new RuntimeException("Erro!");
    }

    public void atualizaLinha(int[] line, char letra) {
        int valor = decode(letra);
        if (valor <= 3) {
            line[valor - 1]++;
        }
    }

}
