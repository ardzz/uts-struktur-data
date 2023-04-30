package Items;
import Helper.PromptHandler;

import java.util.Scanner;

public abstract class AbstractItem {
    protected String[] string_name_data;
    protected String[] integer_name_data;

    protected String[] string_data;
    protected int[] integer_data;
    protected String PromptMessage = "[*] Input data ";

    public String[] getString_name_data() {
        return string_name_data;
    }

    public void setString_name_data(String[] string_name_data) {
        this.string_name_data = string_name_data;
    }

    public String[] getInteger_name_data() {
        return integer_name_data;
    }

    public void setInteger_name_data(String[] integer_name_data) {
        this.integer_name_data = integer_name_data;
    }

    public String[] getString_data() {
        return string_data;
    }

    public void setString_data(String[] string_data) {
        this.string_data = string_data;
    }

    public int[] getInteger_data() {
        return integer_data;
    }

    public void setInteger_data(int[] integer_data) {
        this.integer_data = integer_data;
    }

    public PromptHandler PromptInput(){
        return new PromptHandler(getString_name_data(), getInteger_name_data(), PromptMessage);
    }
}
