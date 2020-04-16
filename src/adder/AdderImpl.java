package adder;

public class AdderImpl implements Adder {
    @Override
    public int add(int summand1, int summand2) throws Exception {
        if(summand1 > 0 && summand2 > 0) {
            // 0 ..... summand1 ..... Integer.MAX_VALUE
            if(Integer.MAX_VALUE - summand1 < summand2) {
                throw new Exception();
            }
        } else if(summand1 < 0 && summand2 < 0) {
            // Integer.MIN_VALUE  summand 1 summand2
            if(Integer.MIN_VALUE - summand1 > summand2) {
                throw new Exception();
            }
        }
        return summand1 + summand2;
    }
}
