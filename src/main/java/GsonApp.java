import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import jakarta.xml.bind.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class GsonApp {
    public static void main(String[] args) throws FileNotFoundException {

        Gson gson = new GsonBuilder().setPrettyPrinting().create();


        List<Employee> employeeList = new ArrayList<>(3);

        employeeList.add(new Employee("Tigran", "Tigranyan", 18, new Address("Erevan", "Armenia", "Mashtots", 2333), new Phone(98777777, "mobile")));
        employeeList.add(new Employee("Arman", "Sargsyan", 20, new Address("Erevan", "Armenia", "Komitas", 23553), new Phone(98777888, "Work")));
        employeeList.add(new Employee("Naarek", "Simonyan", 30, new Address("Erevan", "Armenia", "Adonts", 23443), new Phone(98777999, "Home")));
        try (FileWriter writer = new FileWriter("employee.json")) {
            gson.toJson(employeeList,
                    writer);

        } catch (IOException e) {
            e.printStackTrace();
        }


        try (FileReader reader = new FileReader("employee.json")) {
            JsonArray jsonArray = gson.fromJson(reader, JsonArray.class);
            for (JsonElement jsonElement : jsonArray) {
//                System.out.println(jsonElement.getAsJsonObject().toString());
                String firstName = String.valueOf(jsonElement.getAsJsonObject().get("firstName"));
                String lastName = String.valueOf(jsonElement.getAsJsonObject().get("lastNamae"));
                int age = Integer.parseInt(String.valueOf(jsonElement.getAsJsonObject().get("age")));
                String city = String.valueOf(jsonElement.getAsJsonObject().get("address").getAsJsonObject().get("city"));
                String country = String.valueOf(jsonElement.getAsJsonObject().get("address").getAsJsonObject().get("country"));
                String street = String.valueOf(jsonElement.getAsJsonObject().get("address").getAsJsonObject().get("street"));
                int postalcode = Integer.parseInt(String.valueOf(jsonElement.getAsJsonObject().get("address").getAsJsonObject().get("postalCode")));
                int phoneNUmber = Integer.parseInt(String.valueOf(jsonElement.getAsJsonObject().get("phone").getAsJsonObject().get("phoneNumber")));
                String numType = String.valueOf(jsonElement.getAsJsonObject().get("phone").getAsJsonObject().get("numberType"));
                Employee employee = new Employee(firstName, lastName, age, new Address(city, country, street, postalcode), new Phone(phoneNUmber, numType));
//                System.out.println(employee);
//                System.out.println(numType);


            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();

        }


    }
}
