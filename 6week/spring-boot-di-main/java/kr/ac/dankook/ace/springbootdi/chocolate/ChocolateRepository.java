package kr.ac.dankook.ace.springbootdi.chocolate;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import lombok.Data;

@Repository // Spring component
@Data
public class ChocolateRepository {
    // field-based dependency injection (cannot use final) 
    @Autowired
    private Chocolate chocolate; 
    // field-based dependency injection (cannot use final) 
    @Autowired
    private List<String> nameList;
    // field-based dependency injection (cannot use final) 
    @Autowired
    private Set<String> nameSet;
    // field-based dependency injection (cannot use final) 
    @Autowired
    private Map<Integer, String> nameMap;
    @Autowired
    @Qualifier("chocolateList")
    private List<Chocolate> chocolateList;

    public void printChocolate() {
        System.out.println("\nchocolate=" + chocolate);
    }

    public void printNameList() {
        System.out.println("\nnameList=");
        System.out.println(Arrays.toString(nameList.toArray()));
    }

    public void printNameSet() {
        System.out.println("\nnameSet=");
        System.out.println(Arrays.toString(nameSet.toArray()));
    }

    public void printNameMap() {
        System.out.println("\nnameMap=");
        nameMap.entrySet().stream().forEach(e-> System.out.println(e));
    }

    public void printChocolateList() {
        System.out.println("\nchocolateList=");
        chocolateList.forEach(System.out::println);
    }
}
