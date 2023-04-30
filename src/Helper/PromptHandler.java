package Helper;

import org.jetbrains.annotations.NotNull;

import java.util.Scanner;

public class PromptHandler {
    protected Scanner scanner;
    protected String PromptMessage;
    protected int[] integer_data;
    protected String[] string_data;

    public PromptHandler(String[] string_data, String[] integer_data, String PromptMessage) {
        this.PromptMessage = PromptMessage;
        this.scanner = new Scanner(System.in);
        this.string_data = StringPromptInput(string_data);
         if (integer_data == null){
            this.integer_data = new int[]{};
        } else {
            this.integer_data = IntPromptInput(integer_data);
        }
    }

    protected int[] IntPromptInput(String @NotNull [] integer_data){
        int[] output = new int[integer_data.length];
        for (int i = 0; i < integer_data.length; i++) {
            System.out.print(PromptMessage + integer_data[i] + ": ");
            output[i] = Integer.parseInt(scanner.nextLine());
        }
        return output;
    }

    protected String[] StringPromptInput(String @NotNull [] string_data){
        String[] output = new String[string_data.length];
        for (int i = 0; i < string_data.length; i++) {
            System.out.print(PromptMessage + string_data[i] + ": ");
            output[i] = scanner.nextLine();
        }
        return output;
    }

    public int[] getIntData() {
        return integer_data;
    }

    public String[] getStringData() {
        return string_data;
    }
}
