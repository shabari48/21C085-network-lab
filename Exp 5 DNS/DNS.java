import java.io.IOException;
import java.util.Scanner;

public class DNS {
    public static void main(String[] args) {
        String ipAddress = "";
        try {
            ProcessBuilder ipconfigBuilder = new ProcessBuilder("ipconfig", "/all");
            Process ipconfigProcess = ipconfigBuilder.start();
            Scanner reader = new Scanner(ipconfigProcess.getInputStream());

            String line;
            while (reader.hasNextLine()) {
                line = reader.nextLine();
                if (line.trim().startsWith("DNS Servers")) {
                    ipAddress = line.substring(line.indexOf(":") + 1).trim();
                    System.out.println("DNS Server IP Address: " + ipAddress);
                    break;
                }
            }

            ProcessBuilder nslookupBuilder = new ProcessBuilder("nslookup", ipAddress);
            Process nslookupProcess = nslookupBuilder.start();
            reader = new Scanner(nslookupProcess.getInputStream());

            while (reader.hasNextLine()) {
                line = reader.nextLine();
                if (line.trim().startsWith("Name:")) {
                    String hostname = line.substring(line.indexOf(":") + 1).trim();
                    System.out.println("DNS Server Hostname: " + hostname);
                    break;
                }
            }

            System.out.println("\nResolving Hostname using Local DNS:");
            System.out.print("Enter the host-name to search in DNS: ");

            Scanner inputReader = new Scanner(System.in);
            String inputhost = inputReader.next();

            ProcessBuilder nslookupInputBuilder = new ProcessBuilder("nslookup", inputhost);
            Process nslookupInputProcess = nslookupInputBuilder.start();
            reader = new Scanner(nslookupInputProcess.getInputStream());

            while (reader.hasNextLine()) {
                line = reader.nextLine();
                System.out.println(line);
            }

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
