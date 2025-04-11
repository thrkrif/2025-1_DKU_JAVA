package kr.ac.dankook.ace.springbootdi.chocolate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class ChocolateConfig {
    /*
    // Configuring brand for Chocolate 
    @Bean
	public Brand brand() {
        return new Brand("Chana", "South Korea");
	}

    // Configuring type for Chocolate 
    @Bean
    public Type type() {
        return new Type("Milk Chocolate");
    }
    */
    // Configuring nameList for ChocolateRepository
    @Bean
    public List<String> nameList() {
        return Arrays.asList("Lindt", "Godiva", "Ghirardelli");
    }

    // Configuring nameSet for ChocolateRepository
    @Bean
    public Set<String> nameSet() {
        return new HashSet<>(Arrays.asList("Milk Chocolate", "Dark Chocolate", "Pave Chocolate"));
    }

    // Configuring nameMap for ChocolateRepository
    @Bean
    public Map<Integer, String> nameMap() {
        Map<Integer, String>  nameMap = new HashMap<>();
        nameMap.put(1, "M&M's");
        nameMap.put(2, "Reese's");
        nameMap.put(3, "Hershey");
        return nameMap;
    }

    // Configuring chocolateList 
    @Bean
    @Qualifier("chocolateList")
    public List<Chocolate> chocolateList() {
        List<Chocolate> chocolateList = new ArrayList<Chocolate>();
        chocolateList.add(new Chocolate(new Brand("Lindt", "Swiss"), new Type("Milk Chocolate")));
        chocolateList.add(new Chocolate(new Brand("Godiva", "Belgium"), new Type("Dark Chocolate")));
        chocolateList.add(new Chocolate(new Brand("Ghirardelli", "USA"), new Type("Dark Chocolate")));
        chocolateList.add(new Chocolate(new Brand("Ferrero Rocher", "Italy"), new Type("Nutella Chocolate")));
        chocolateList.add(new Chocolate(new Brand("Royce", "Japan"), new Type("Pave Chocolate")));
        return chocolateList;
    }

    // Configuring ChocolateRepository with chocolateList
    @Bean
    public ChocolateRepository chocolateRepository() {
        ChocolateRepository chocolateRepository = new ChocolateRepository();
		chocolateRepository.setChocolateList(chocolateList()); // setter DI
        return chocolateRepository;
    }

}
