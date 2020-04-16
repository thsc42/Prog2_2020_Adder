package adder;

public interface Adder {
    /**
     * Addiert zwei Werte
     * @param summand1
     * @param summand2
     * @return summe
     * @throws Exception wenn ein Überlauf passiert
     */
    int add(int summand1, int summand2) throws Exception;
}
