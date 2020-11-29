package mangement;

import java.math.BigDecimal;
import java.sql.Connection;

public interface DataBaseManagement {


    Connection connect();

    void selectAll();

    void add(String s, BigDecimal b, String t, int i);

    void add(String s, String b);

    void update(int o, String s, BigDecimal b, String t, int i);

    void update(int i, String s, String b);

    void delete(int i);


}
