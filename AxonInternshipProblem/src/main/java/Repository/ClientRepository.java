package Repository;

import Domain.Client;

import java.io.*;
import java.util.*;

public class ClientRepository implements Repository {

    private List<Client> clients;
    private List<String> filename;

    public ClientRepository(List<String> filename) throws IOException {
        this.filename = filename;
        this.clients = new ArrayList<>();
        readFromFile();
    }

    public List<Client> getClients() {
        return clients;
    }

    /***
     * Reads data from all client files.
     * @throws IOException
     */
    @Override
    public void readFromFile() throws IOException {
        for (String s : filename) {
            File file = new File(s);
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));

            List<String> split = Arrays.asList(s.split("_"));//split the name of the file for name and date
            String name = split.get(1);
            String date = split.get(2);
            date = date.split(".txt")[0];
            List<String> productList = new ArrayList<>();
            Map<Integer, String> marketPriority = new HashMap<>();
            String currentLine;
            boolean firstLine = true;
            while ((currentLine = bufferedReader.readLine()) != null){
                if(firstLine) {
                    List<String> list = Arrays.asList(currentLine.split(";"));//split the first row for products
                    productList.addAll(list);
                    firstLine = false;
                }
                else {
                    List<String> line = Arrays.asList(currentLine.split(":"));//split every next line for a market and its priority, then put them in a map
                    marketPriority.put(Integer.parseInt(line.get(1)), line.get(0));
                }
            }
            Client client = new Client(name,date,productList,marketPriority);
            clients.add(client);
        }
    }
}
