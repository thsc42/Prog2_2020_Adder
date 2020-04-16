package memory;

import java.io.IOException;

public interface Speicher {
    void setValue(int value) throws IOException;

    int getValue() throws IOException;
}
