import java.util.*;


class PythagoreanTriplet {
    final int[] sides;
    PythagoreanTriplet(int a, int b, int c) {

        if (!(a * a + b * b == c * c)) throw new IllegalArgumentException();
        this.sides = new int[] {a, b, c};

    }


    @Override
    public boolean equals(Object other) {

        if (this == other) return true;

        if (!(other instanceof PythagoreanTriplet)) return false;

        PythagoreanTriplet that = (PythagoreanTriplet)other;

        return

            this.sides[0] == that.sides[0] &&

            this.sides[1] == that.sides[1] &&

            this.sides[2] == that.sides[2];

    }

    static PythagoreanTripletFactory makeTripletsList() {

        return new PythagoreanTripletFactory();

    }

}

class PythagoreanTripletFactory {

    private int factorMax = 0;

    private int sum = 0;

    PythagoreanTripletFactory withFactorsLessThanOrEqualTo(int factorMax) {

        this.factorMax = factorMax;

        return this;

    }

    PythagoreanTripletFactory thatSumTo(int sum) {

        this.sum = sum;

        return this;

    }

    List<PythagoreanTriplet> build() {

        var triplets = new ArrayList<PythagoreanTriplet>();


        for (int i = 3; i < factorMax; i += 1) {

            for (int j = i; j < factorMax && 3 <= sum - i - j; j += 1) {

                int k = sum - i - j;

                int lhs = i * i + j * j;

                int rhs = k * k;

                if (lhs > rhs) break;

                if (lhs == rhs) triplets.add(new PythagoreanTriplet(i, j, k));

            }

        }

        return triplets;

    }

}

