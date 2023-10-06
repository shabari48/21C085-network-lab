import java.io.*;

public class Net3{

  public static void main(String[] args) throws Exception {
    try {
      ProcessBuilder builder = new ProcessBuilder("cmd.exe", "/c", "arp -a");
      builder.redirectErrorStream(true);
      Process p = builder.start();
      BufferedReader r = new BufferedReader(
        new InputStreamReader(p.getInputStream())
      );
      String line;
      int index = 0;
      while (true) {
        line = r.readLine();
        if (line == null) {
          break;
        }
        if (index == 3) {
          String data[] = splitter(line);
          System.out.println("Next Hop's IP Address: " + data[0]);
          System.out.println("Next Hop's MAC Address: " + data[1]);
          break;
        }
        index++;
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static String[] splitter(String line) {
    String[] data = new String[3];
    String word = "";
    int index = 0;
    for (int i = 0; i < line.length(); i++) {
      if (line.charAt(i) == ' ') {
        if (!word.equals("")) {
          data[index++] = word;
        }
        word = "";
      } else {
        word += line.charAt(i);
      }
    }
    return data;
  }
}
