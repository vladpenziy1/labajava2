package lab2;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.*;

public interface Serializate {

    default void SerializeToXml(Company company) {

         File file = new File("Company.xml");
             try {
                 JAXBContext jc = JAXBContext.newInstance(Company.class);
                 Marshaller marshaller = jc.createMarshaller();

                 marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true);
                 marshaller.marshal(company,file);
                 marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true);
                 marshaller.marshal(company,System.out);
             } catch (JAXBException e) {
                 e.printStackTrace();
             }
    }

    default Company SerializeFromXml(){

        File file = new File("Company.xml");

        Company company = new Company();
        JAXBContext jc = null;
        try {
            jc = JAXBContext.newInstance(Company.class);
            Unmarshaller unmarshaller = jc.createUnmarshaller();
            company = (Company) unmarshaller.unmarshal(file);
            return company;
        } catch (JAXBException e) {
            e.printStackTrace();
        }

        return null;
    }


    default void SerializeToJson(Company company){

        File file = new File("Company.json");

        ObjectMapper mapper = new ObjectMapper();

        try {
            mapper.writerWithDefaultPrettyPrinter().writeValue(file, company);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    default Company SerializeFromJson(){

        File file = new File("Company.json");
        Company company = null;
        ObjectMapper mapper = new ObjectMapper();
        try {
           company =  mapper.readValue(file,Company.class);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return company;

    }

    default void SerializeToTxt(Company company){

        File file = new File("Company.txt");

        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            fos = new FileOutputStream(file);
            if(fos != null) {
                try {
                    oos = new ObjectOutputStream(fos);
                    oos.writeObject(company);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }finally {
            if(oos != null){
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    default Company SerializeFromTxt(){

        File file = new File("Company.txt");

        FileInputStream fis = null;
        try {
            fis = new FileInputStream(file);
            if(fis != null) {
                try {
                    ObjectInputStream ois = new ObjectInputStream(fis);
                    try {
                        Company company = (Company) ois.readObject();
                        return company;
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return null;
    }
}
