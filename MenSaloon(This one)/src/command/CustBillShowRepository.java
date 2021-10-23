package command;
//Creating a concrete class which implements the Container interface. 
//This class has inner class SeatingIterator that implements the Iterator interface.

import iterator.Iterator;
import iterator.Container;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

class CustBillShowRepository implements Container {

    public int custbilldata[] = {1};

    public CustBillShowRepository() {

        try {
            Scanner input = new Scanner(System.in);
            System.out.println("Enter Customer's ID to view his bill: ");
            String cust_id = input.next();
            String filename = cust_id + "Bill.txt";
            
            
            ArrayList<String> lines = null;
            lines = new ArrayList<>(Files.readAllLines(Paths.get(filename))); // Handle a potential exception

            System.out.println("***************CUSTOMER's BILL*****************");
            System.out.println("___________________________________________");
            System.out.println("Customer's ID           : " + lines.get(0));
            System.out.println("Customer's Name         : " + lines.get(1));
            System.out.println("Customer's Phone Number : " + lines.get(2));
            System.out.print("Customer's Total Bill   : ");
            int total = 0;
            for (int k = 3; k < lines.size(); k++) {
                total += Integer.parseInt(lines.get(k));

            }
            custbilldata[0] = total;


        } catch (IOException | NumberFormatException e) {

        }

//        try {
//            ArrayList<String> lines = new ArrayList<>(Files.readAllLines(Paths.get("JoeBiden.txt")));
//            ArrayList<String> lines1 = new ArrayList<>(Files.readAllLines(Paths.get("DonaldTrump.txt")));
//            seating[0] += String.valueOf(lines.size());
//            seating[1] += String.valueOf(lines1.size());
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
    }

    @Override
    public Iterator getIterator() {
        return new SeatingIterator();
    }

    private class SeatingIterator implements Iterator {

        int index;

        public boolean hasNext() {

            if (index < custbilldata.length) {
                return true;
            }
            return false;
        }

        public Object next() {

            if (this.hasNext()) {
                return custbilldata[index++];
            }
            return null;
        }
    }
}
