package codility.lessons;

class EquiLeaders {
    public int solution(int[] A) {
        int delta = 0;
        int candidate = -1;
        for (int i = 0; i < A.length; i++) {
            if (delta == 0) {
                candidate = A[i];
                delta++;
            } else if (candidate == A[i]) {
                delta++;
            } else {
                delta--;
            }
        }

        int totalCount = 0;
        if (delta == 0) {
            return 0;
        } else {
            for (int i = 0; i < A.length; i++) {
                if (candidate == A[i]) {
                    totalCount++;
                }
            }
        }

        if (totalCount <= A.length / 2) {
            return 0;
        }

        int equileaders = 0;
        int partialCount = 0;

        for (int i = 0; i < A.length - 1; i++) {
            if (A[i] == candidate) {
                partialCount++;
            }
            boolean equileaderBefore = partialCount > ((i + 1) / 2);
            boolean equileaderLater = (totalCount - partialCount) > (A.length - (i + 1)) / 2;
            if (equileaderBefore && equileaderLater) {
                equileaders++;
            }
        }

        return equileaders;

    }
}