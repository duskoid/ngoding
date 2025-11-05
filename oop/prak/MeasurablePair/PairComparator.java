public final class PairComparator {
    private PairComparator() {
    }

    // TODO:
    // 1. Lengkapi parameter generik method yang merupakan kelas-kelas yang
    // menerapkan interface Comparable
    // 2. Lengkapi parameter generik dari pair yang dibandingkan
    public static <T extends Measurable<T>, R extends Measurable<R>, U extends T, V extends R> boolean isGreater(Pair<T, R> p1, Pair<U, V> p2) {
    return p1.getFirst().compareTo(p2.getFirst()) > 0 && p1.getSecond().compareTo(p2.getSecond()) > 0;
}
}
