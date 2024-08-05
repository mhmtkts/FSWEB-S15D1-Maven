package org.example.mobile;

import java.util.ArrayList;
import java.util.List;

public class MobilePhone {
    private String myNumber;
    private List<Contact> myContacts = new ArrayList<>();


    public MobilePhone(String myNumber) {
        this.myNumber = myNumber;
    }

    public MobilePhone(String myNumber, List<Contact> myContacts) {
        this.myNumber = myNumber;
        this.myContacts = myContacts;
    }

    public String getMyNumber() {
        return myNumber;
    }

    public List<Contact> getMyContacts() {
        return myContacts;
    }

    public boolean addNewContact(Contact contact) {
        if (contact == null || contact.getName() == null || contact.getPhoneNumber()==null){
            return false;
        }
        if (findContact(contact.getName()) >=0) {
            return false ;
        }
        return myContacts.add(contact);
    }
    public boolean updateContact(Contact contact, Contact updatedContact) {
        int index = findContact(contact);
        if (index <= 0) {
            return false;
        }
        myContacts.set(index, updatedContact);
        return true;
    }

    public boolean removeContact(Contact contact) {
        if (contact == null || findContact(contact) < 0) {
            return false;
        }
        return myContacts.remove(contact);
    }

    public int findContact(Contact contact) {

        return myContacts.indexOf(contact);
    }

    public int findContact(String name) {
        for (int i = 0; i < myContacts.size(); i++) {
            Contact contact = myContacts.get(i);
            if (contact.getName().equals(name)) {
                return i;
            }
        }
        return -1;
    }

    public Contact queryContact(String contact) {
        int contactIndex = findContact(contact);
        if (contactIndex <= 0) {
            return null;
        }
        return myContacts.get(contactIndex);
    }

    public void printContacts() {
        for (int i = 0; i < myContacts.size(); i++) {
            Contact contact = myContacts.get(i);
            System.out.println((i + 1) + contact.getName() + " " + contact.getPhoneNumber());
        }
    }
}
