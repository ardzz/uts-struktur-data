import Helper.DummyDataHandler;
import Items.Book;
import Items.Pen;
import Items.Ruler;
import LinkedList.List;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import java.util.Scanner;
public class StationeryStore {
    public static void main(String[] args) throws ParseException {
        DummyDataHandler DummyDataHandler = new DummyDataHandler();
        Scanner scanner = new Scanner(System.in);

        JSONArray dummy_books = DummyDataHandler.getDummyData(new Book());
        JSONArray dummy_pens = DummyDataHandler.getDummyData(new Pen());
        JSONArray dummy_rulers = DummyDataHandler.getDummyData(new Ruler());

        List available_books = new List();
        List available_pens = new List();
        List available_rulers = new List();
        List cart_books = new List();
        List cart_pens = new List();
        List cart_rulers = new List();
        List sold_books = new List();
        List sold_pens = new List();
        List sold_rulers = new List();


        List[] list_class = {
                available_books,
                available_pens,
                available_rulers,
                cart_books,
                cart_pens,
                cart_rulers,
                sold_books,
                sold_pens,
                sold_rulers
        };

        int index_item = 1;
        for (List list : list_class) {
            if (index_item >= 3) {
                index_item = 1;
            }
            switch (index_item) {
                case 1:
                    list.setItemInstance(new Book());
                    break;
                case 2:
                    list.setItemInstance(new Pen());
                    break;
                case 3:
                    list.setItemInstance(new Ruler());
                    break;
            }
            index_item++;
        }

        add_dummy(dummy_books, available_books);
        add_dummy(dummy_pens, available_pens);
        add_dummy(dummy_rulers, available_rulers);

        System.out.println("Selamat datang di toko alat tulis!");
        System.out.println("Berikut adalah menu yang tersedia:");
        System.out.println("1. Lihat barang yang tersedia");
        System.out.println("2. Tambahkan barang ke keranjang");
        System.out.println("3. Lihat barang di keranjang");
        System.out.println("4. Hapus barang dari keranjang");
        System.out.println("5. Tambahkan barang ke stok");
        System.out.println("6. Hapus barang dari stok");
        System.out.println("7. Lihat barang yang terjual");
        System.out.println("8. Checkout");


        System.out.print("Masukkan pilihan: ");
        int menu_choice = Integer.parseInt(scanner.nextLine());
        while (menu_choice != 8) {
            switch (menu_choice) {
                case 1:
                    System.out.println("Berikut adalah barang yang tersedia:");
                    System.out.println("1. Buku");
                    System.out.println("2. Pensil");
                    System.out.println("3. Penggaris");
                    System.out.print("Masukkan pilihan: ");
                    int item_choice = Integer.parseInt(scanner.nextLine());
                    choose_item(available_books, available_pens, available_rulers, item_choice);
                    break;
                case 2:
                    System.out.println("Berikut adalah barang yang tersedia:");
                    System.out.println("1. Buku");
                    System.out.println("2. Pensil");
                    System.out.println("3. Penggaris");
                    System.out.print("Masukkan pilihan: ");
                    int item_choice_2 = Integer.parseInt(scanner.nextLine());
                    switch (item_choice_2) {
                        case 1:
                            available_books.print_item();
                            System.out.print("Masukkan nomor barang yang ingin ditambahkan: ");
                            int item_number = Integer.parseInt(scanner.nextLine());
                            cart_books.add(available_books.get(item_number));
                            break;
                        case 2:
                            available_pens.print_item();
                            System.out.print("Masukkan nomor barang yang ingin ditambahkan: ");
                            int item_number_2 = Integer.parseInt(scanner.nextLine());
                            cart_pens.add(available_pens.get(item_number_2));
                            break;
                        case 3:
                            available_rulers.print_item();
                            System.out.print("Masukkan nomor barang yang ingin ditambahkan: ");
                            int item_number_3 = Integer.parseInt(scanner.nextLine());
                            cart_rulers.add(available_rulers.get(item_number_3));
                            break;
                    }
                    break;
                case 3:
                    System.out.println("Berikut adalah barang yang ada di keranjang:");
                    System.out.println("1. Buku");
                    System.out.println("2. Pensil");
                    System.out.println("3. Penggaris");
                    System.out.print("Masukkan pilihan: ");
                    int item_choice_3 = Integer.parseInt(scanner.nextLine());
                    choose_item(cart_books, cart_pens, cart_rulers, item_choice_3);
                    break;
                case 4:
                    System.out.println("Berikut adalah barang yang ada di keranjang:");
                    System.out.println("1. Buku");
                    System.out.println("2. Pensil");
                    System.out.println("3. Penggaris");
                    System.out.print("Masukkan pilihan: ");
                    int item_choice_4 = Integer.parseInt(scanner.nextLine());
                    remove_item_from_stock(scanner, cart_books, cart_pens, cart_rulers, item_choice_4);
                    break;
                case 5:
                    System.out.println("Berikut adalah barang yang ada di keranjang:");
                    System.out.println("1. Buku");
                    System.out.println("2. Pensil");
                    System.out.println("3. Penggaris");
                    System.out.print("Masukkan pilihan: ");
                    int item_choice_6 = Integer.parseInt(scanner.nextLine());
                    switch (item_choice_6) {
                        case 1:
                            System.out.println("1. Tambahkan data pertama ke stok");
                            System.out.println("2. Tambahkan data terkahir ke stok");
                            System.out.println("3. Tambahkan data di tengah ke stok");
                            System.out.print("Masukkan pilihan: ");

                            int item_choice_7 = Integer.parseInt(scanner.nextLine());
                            add_data(scanner, cart_books, item_choice_7);
                            break;
                        case 2:
                            System.out.println("1. Tambahkan data pertama ke stok");
                            System.out.println("2. Tambahkan data terkahir ke stok");
                            System.out.println("3. Tambahkan data di tengah ke stok");
                            System.out.print("Masukkan pilihan: ");

                            int item_choice_8 = Integer.parseInt(scanner.nextLine());
                            add_data(scanner, cart_pens, item_choice_8);
                            break;
                        case 3:
                            System.out.println("1. Tambahkan data pertama ke stok");
                            System.out.println("2. Tambahkan data terkahir ke stok");
                            System.out.println("3. Tambahkan data di tengah ke stok");
                            System.out.print("Masukkan pilihan: ");

                            int item_choice_9 = Integer.parseInt(scanner.nextLine());
                            add_data(scanner, cart_rulers, item_choice_9);
                            break;
                    }
                    break;
                case 6:
                    System.out.println("Berikut adalah barang yang ada di keranjang:");
                    System.out.println("1. Buku");
                    System.out.println("2. Pensil");
                    System.out.println("3. Penggaris");
                    System.out.print("Masukkan pilihan: ");
                    int item_choice_10 = Integer.parseInt(scanner.nextLine());
                    switch (item_choice_10) {
                        case 1:
                            System.out.println("1. Hapus data pertama dari stok");
                            System.out.println("2. Hapus data terkahir dari stok");
                            System.out.println("3. Hapus data di tengah dari stok");
                            System.out.print("Masukkan pilihan: ");

                            int item_choice_11 = Integer.parseInt(scanner.nextLine());
                            remove_data(scanner, cart_books, item_choice_11);
                            break;
                        case 2:
                            System.out.println("1. Hapus data pertama dari stok");
                            System.out.println("2. Hapus data terkahir dari stok");
                            System.out.println("3. Hapus data di tengah dari stok");
                            System.out.print("Masukkan pilihan: ");

                            int item_choice_12 = Integer.parseInt(scanner.nextLine());
                            remove_data(scanner, cart_pens, item_choice_12);
                            break;
                        case 3:
                            System.out.println("1. Hapus data pertama dari stok");
                            System.out.println("2. Hapus data terkahir dari stok");
                            System.out.println("3. Hapus data di tengah dari stok");
                            System.out.print("Masukkan pilihan: ");

                            int item_choice_13 = Integer.parseInt(scanner.nextLine());
                            remove_data(scanner, cart_rulers, item_choice_13);
                            break;
                    }
                    break;
                case 7:
                    System.out.println("Berikut adalah barang yang ada di keranjang:");
                    System.out.println("1. Buku");
                    System.out.println("2. Pensil");
                    System.out.println("3. Penggaris");
                    System.out.print("Masukkan pilihan: ");
                    int item_choice_5 = Integer.parseInt(scanner.nextLine());
                    choose_item(cart_books, cart_pens, cart_rulers, item_choice_5);
                    System.out.println("Total harga: " + cart_books.get_total_price() + cart_pens.get_total_price() + cart_rulers.get_total_price());
                    break;
            }
        }
    }

    private static void remove_item_from_stock(Scanner scanner, List cartBooks, List cartPens, List cartRulers, int itemChoice4) {
        switch (itemChoice4) {
            case 1:
                System.out.println("1. Hapus data pertama dari stok");
                System.out.println("2. Hapus data terkahir dari stok");
                System.out.println("3. Hapus data di tengah dari stok");
                System.out.print("Masukkan pilihan: ");
                int itemChoice5 = Integer.parseInt(scanner.nextLine());
                remove_data(scanner, cartBooks, itemChoice5);
                break;
            case 2:
                System.out.println("1. Hapus data pertama dari stok");
                System.out.println("2. Hapus data terkahir dari stok");
                System.out.println("3. Hapus data di tengah dari stok");
                System.out.print("Masukkan pilihan: ");
                int itemChoice6 = Integer.parseInt(scanner.nextLine());
                remove_data(scanner, cartPens, itemChoice6);
                break;
            case 3:
                System.out.println("1. Hapus data pertama dari stok");
                System.out.println("2. Hapus data terkahir dari stok");
                System.out.println("3. Hapus data di tengah dari stok");
                System.out.print("Masukkan pilihan: ");
                int itemChoice7 = Integer.parseInt(scanner.nextLine());
                remove_data(scanner, cartRulers, itemChoice7);
                break;
        }
    }

    private static void remove_data(Scanner scanner, List cart, int itemChoice) {
        switch (itemChoice) {
            case 1:
                cart.remove_first();
                break;
            case 2:
                cart.remove_last();
                break;
            case 3:
                cart.print_item();
                System.out.print("Masukkan nomor barang yang ingin dihapus dari stok: ");
                int item_number_9 = Integer.parseInt(scanner.nextLine());
                cart.remove(item_number_9);
                break;
        }
    }

    public static void add_data(Scanner scanner, List cart_rulers, int item_choice_9) {
        switch (item_choice_9) {
            case 1:
                cart_rulers.add_first();
                break;
            case 2:
                cart_rulers.add_last();
                break;
            case 3:
                cart_rulers.print_item();
                System.out.print("Masukkan nomor barang yang ingin ditambahkan ke stok: ");
                int item_number_9 = Integer.parseInt(scanner.nextLine());
                cart_rulers.add_at(item_number_9);
                break;
        }
    }

    public static void add_dummy(JSONArray dummy_pens, List available_pens) {
        for (Object dummy_pen : dummy_pens) {
            JSONObject pen = (JSONObject) dummy_pen;
            available_pens.getItemInstance().setString_data(new String[]{
                    (String) pen.get("merk"),
                    (String) pen.get("ukuran")
            });
            available_pens.getItemInstance().setInteger_data(new int[]{
                    Integer.parseInt(String.valueOf(pen.get("harga")))
            });
            available_pens.add(available_pens.getItemInstance());
        }
    }

    public static void choose_item(List available_books, List available_pens, List available_rulers, int item_choice) {
        switch (item_choice) {
            case 1:
                available_books.print_item();
                break;
            case 2:
                available_pens.print_item();
                break;
            case 3:
                available_rulers.print_item();
                break;
        }
    }
}
