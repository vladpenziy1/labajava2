package lab2;

import java.util.ArrayList;
import java.util.List;


public class Main {


    public static void main(String args[]){

        Worker w1 = new Worker();

        w1.setId(1);
        w1.setSurname("Andrienko");
        w1.setName("Petro");
        w1.setLastname("Mykolayovych");
        w1.setGender("Male");
        w1.setAge(40);
        w1.older();
        w1.worker();
        w1.getGenderStr();

        Worker w2 = new Worker();
        w2.setId(2);
        w2.setSurname("Stepanov");
        w2.setName("Mariya");
        w2.setLastname("Stepanovivna");
        w2.setGender("Female");
        w2.setAge(41);
        w2.older();
        w2.worker();
        w2.getGenderStr();

        Worker w3 = new Worker();
        w3.setId(3);
        w3.setSurname("Ivanenko");
        w3.setName("Svitlana");
        w3.setLastname("Ivanovivna");
        w3.setGender("Female");
        w3.setAge(40);
        w3.older();
        w3.worker();
        w3.getGenderStr();

        Worker w4 = new Worker();
        w4.setId(4);
        w4.setSurname("Maksymov");
        w4.setName("Maksym");
        w4.setLastname("Maksymovych");
        w4.setAge(36);
        w4.setGender("Male");
        w4.older();
        w4.worker();
        w4.getGenderStr();

        Worker w5 = new Worker();
        w5.setId(5);
        w5.setSurname("Loza");
        w5.setName("Ihor");
        w5.setLastname("Petrovych");
        w5.setAge(19);
        w5.setGender("Male");
        w5.older();
        w5.worker();
        w5.getGenderStr();

        Worker w6 = new Worker();
        w6.setId(6);
        w6.setSurname("Kyznecova");
        w6.setName("Olena");
        w6.setLastname("Dmytrivna");
        w6.setAge(54);
        w6.setGender("Female");
        w6.older();
        w6.worker();
        w6.getGenderStr();

        Worker w7 = new Worker();
        w7.setId(7);
        w7.setSurname("Vatin");
        w7.setName("Volodymyr");
        w7.setLastname("Viktorovych");
        w7.setAge(35);
        w7.setGender("Male");
        w7.older();
        w7.worker();
        w7.getGenderStr();



        Company company = new Company();
        company.setNumberCompany(1);
        company.setNameCompany("Glovo");
        List<Worker> list = new ArrayList<Worker>();
        list.add(w1);
        list.add(w2);
        list.add(w6);
        company.setList(list);

        company.SerializeToTxt(company);
      Company company1 = company.SerializeFromTxt();
        System.out.println(company1);


        Company company2 = new Company();
        company2.setNumberCompany(2);
        company2.setNameCompany("Softserve");
        List<Worker> list1 = new ArrayList<Worker>();

        list1.add(w3);
        list1.add(w7);
        list1.add(w5);
        list1.add(w6);

        company2.setList(list1);

        company2.SerializeToXml(company2);

        Company company3 = company2.SerializeFromXml();
        System.out.println(company3);

       Company company4 = new Company();
        company4.setNumberCompany(3);
        company4.setNameCompany("Nova pochta");

       List<Worker> list2 = new ArrayList<Worker>();

        list2.add(w4);
        list2.add(w2);
        list2.add(w5);
        list2.add(w1);

        company4.setList(list2);

        company4.SerializeToJson(company4);

        Company company5 = company4.SerializeFromJson();
        System.out.println(company5);

    }
}
