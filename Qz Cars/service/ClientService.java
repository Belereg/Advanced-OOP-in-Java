package com.company.service;


import com.company.model.Client;
import com.company.repository.ClientRepository;

import java.util.Date;

public class ClientService {

    private static ClientService instance;

    private final ClientRepository clientRepository = ClientRepository.getInstance();

    private ClientService() {
    }

    public static ClientService getInstance() {
        if (instance == null) {
            instance = new ClientService();
        }

        return instance;
    }

    public Client saveClient(Integer id, Short age, String name) {
        Client client = new Client();
        client.setId(id);
        client.setName(name);
        client.setAge(age);
        return clientRepository.saveClient(client);
    }

    public Client findClient(Integer id) {
        return clientRepository.findClient(id);
    }

    public Client updateClient(Client client) {
        return clientRepository.updateClient(client);
    }

    public boolean deleteClient(Client client) {
        return clientRepository.deleteClient(client.getId());
    }

//    public Client findNewestMember() {
//        return clientRepository.findNewestMember();
//    }
}
