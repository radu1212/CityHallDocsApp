package service;

import entity.Address;
import entity.User;
import repository.AddressRepo;
import repository.UserRepo;

public class AddressService {

    private AddressRepo addressRepo;

    public AddressService() {
        this.addressRepo = new AddressRepo();
    }

    public void addValidatedAddressToDB(String street, String number, String apartment, String city, String county, User user){
        addressRepo.insertNewAddress( street,  number,  apartment,  city,  county,  user);
    }

    public void addValidatedAddressToDB(Address address){
        addressRepo.insertNewAddress( address.getStreet(),  address.getNumber(),  address.getApartment(), address.getCity(), address.getCounty(), address.getUser());
    }

}
