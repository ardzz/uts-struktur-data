package Items;

public class Pen extends AbstractItem {
    protected String[] string_data = {
            "merk", "ukuran"
    };

    protected String[] integer_data = {
            "harga"
    };

    public Pen(){
        super();
        setString_name_data(string_data);
        setInteger_name_data(integer_data);
    }
}
