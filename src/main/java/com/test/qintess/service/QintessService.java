package com.test.qintess.service;

import com.sun.webkit.dom.HTMLCollectionImpl;
import com.test.qintess.dto.personList;
import com.test.qintess.dto.personListResult;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class QintessService {

    public List<personListResult> getSortedAge(List<personList> list){
        List<personListResult> result = new ArrayList<>();
        Collections.sort(list, new Comparator<personList>() {
            @Override
            public int compare(personList o1, personList o2) {
                return new Integer(o1.getAge()).compareTo(new Integer(o2.getAge()));
            }
        });
        //obtener edades
        List<Integer> ages = new ArrayList<>();
        for (int i = 0; i < list.size(); i++){
            ages.add(list.get(i).getAge());
        }
        HashSet hs = new HashSet();
        hs.addAll(ages);
        ages.clear();
        ages.addAll(hs);

        //ordenar por edad y generar respuesta
        for (int i = 0; i < ages.size(); i++){
            for (int j = 0; j < list.size(); j++){
                if (list.get(j).getAge() == ages.get(i)){
                    personList person = new personList(list.get(j).getAge(),list.get(j).getName());
                    personListResult personListResult = new personListResult(ages.get(i),person);
                    result.add(personListResult);
                }
            }
        }
        Collections.sort(result, new Comparator<personListResult>() {
            @Override
            public int compare(personListResult o1, personListResult o2) {
                return new Integer(o1.getAge()).compareTo(new Integer(o2.getAge()));
            }
        });
        return result;
    }

    public List<personListResult> getSortedAgeandName(List<personList> list){
        List<personListResult> result = new ArrayList<>();
        List<personList> resultPerson = new ArrayList<>();

        Collections.sort(list, new Comparator<personList>() {
            @Override
            public int compare(personList o1, personList o2) {
                return new Integer(o1.getAge()).compareTo(new Integer(o2.getAge()));
            }
        });
        //obtener edades
        List<Integer> ages = new ArrayList<>();
        for (int i = 0; i < list.size(); i++){
            ages.add(list.get(i).getAge());
        }
        HashSet hs = new HashSet();
        hs.addAll(ages);
        ages.clear();
        ages.addAll(hs);

        //ordenar por edad y generar respuesta
        for (int i = 0; i < ages.size(); i++){
            for (int j = 0; j < list.size(); j++){
                List<String> names = new ArrayList<>();
                if (list.get(j).getAge() == ages.get(i)){
                    personList person = new personList(list.get(j).getAge(),list.get(j).getName());
                    resultPerson.add(person);
                }
            }
        }

        Comparator<personList> compareAgeName = Comparator.comparing(personList::getAge)
                                                .thenComparing(personList::getName);

        List<personList> resultPerson_sorted = resultPerson.stream()
                .sorted(compareAgeName).collect(Collectors.toList());

        Collections.sort(ages);

        for (int k = 0; k < ages.size(); k++){
            for (int m = 0; m < resultPerson_sorted.size(); m++){
                if (ages.get(k) == resultPerson_sorted.get(m).getAge()){
                    personList person = new personList(0,"");
                    person.setAge(resultPerson_sorted.get(m).getAge());
                    person.setName(resultPerson_sorted.get(m).getName());
                    result.add(new personListResult(ages.get(k),person));
                }
            }
        }

        return result;
    }


}