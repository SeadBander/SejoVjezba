package six;

import java.util.List;

public interface Dao<E> {

    public void write(List<E> elements);

    public List<E> read();
}
