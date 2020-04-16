package memory;

import java.io.IOException;

public class SpeicherImpl implements Speicher {
    private int value = 0;

    @Override
    public void setValue(int value) throws IOException {
        this.value = value;
    }

    @Override
    public int getValue() throws IOException {
        return this.value;
    }
}
