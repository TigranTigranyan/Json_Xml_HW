import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;

import java.io.File;

public class XmlApp {
    public static void main(String[] args) {
        JAXBContext jaxbContext = null;
        try {
            jaxbContext = JAXBContext.newInstance(Employee.class);
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true);
            Employee employee = new Employee("Suzy", "Melkonyan", 1,new Address("erevan","armenia","komitas",12345),new Phone(987654321,"work"));
            marshaller.marshal(employee, new File("employee.xml"));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
