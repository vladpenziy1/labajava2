package lab2;

import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
@XmlRootElement(name = "company")
@XmlAccessorType(XmlAccessType.NONE)
@XmlType(propOrder = {"numberCompany","nameCompany","list"})
public class Company implements Serializate, Serializable {

    private String nameCompany;
    private int numberCompany;
    private List<Worker> list;

    public String getNameCompany() {
        return nameCompany;
    }
    @XmlElement
    public void setNameCompany(String nameCompany) {
        this.nameCompany = nameCompany;
    }

    public int getNumberCompany() {
        return numberCompany;
    }
    @XmlAttribute(name = "id")
    public void setNumberCompany(int numberCompany) {
        this.numberCompany = numberCompany;
    }

    public List<Worker> getList() {
        return list;
    }

    @XmlElement(name = "workers")
    public void setList(List<Worker> list) {
        this.list = list;
    }


    //@XmlElement
    public List<Worker> filter(List<Worker> list){

        for(int i = list.size()-1; i >=0 ;i--){
            if(list.get(i).getAge() > 40) {
                list.remove(i);
            }
        }

        return list;
    }


   // @XmlElement
    public List<Worker> sort(List<Worker> list){
        Collections.sort(list, new Comparator() {
            @Override
            public int compare(Object WorkerOne, Object WorkerTwo) {
                return ((Worker) WorkerOne).getSurname().compareTo(((Worker) WorkerTwo).getSurname());
            }
        });

        return list;
    }

    @Override
    public String toString(){
        return "\nName company: -> " + nameCompany
                + "\nCode company: -> " + numberCompany
                + "\nList workers: -> "+list +
                "\n";
    }

}
