import Controller.Controller;
import Domain.Client;
import Domain.Market;
import Repository.ClientRepository;
import Repository.MarketRepository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {

        List<String> clientFiles = new ArrayList<>();
        clientFiles.add("D:\\MetPP\\AxonInternshipProblem\\src\\main\\resources\\comanda_Popescu Dan_2020-04-26.txt");
        clientFiles.add("D:\\MetPP\\AxonInternshipProblem\\src\\main\\resources\\comanda_Ionescu Maria_2020-04-15.txt");
        clientFiles.add("D:\\MetPP\\AxonInternshipProblem\\src\\main\\resources\\comanda_Florescu Ana_2020-04-30.txt");
        ClientRepository clientRepository = new ClientRepository(clientFiles);

        List<String> marketFiles = new ArrayList<>();
        marketFiles.add("D:\\MetPP\\AxonInternshipProblem\\src\\main\\resources\\magazin_Auchan.txt");
        marketFiles.add("D:\\MetPP\\AxonInternshipProblem\\src\\main\\resources\\magazin_Lidl.txt");
        marketFiles.add("D:\\MetPP\\AxonInternshipProblem\\src\\main\\resources\\magazin_Mega Image.txt");
        MarketRepository marketRepository = new MarketRepository(marketFiles);


        Controller controller = new Controller(clientRepository,marketRepository);

        controller.writeToFile();

    }


}
