import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String []args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入指令");
        Collect collect = new Collect();
        while(scanner.hasNextLine()){
            String address = scanner.nextLine();
            collect.collect(address);
        }
    }
}
