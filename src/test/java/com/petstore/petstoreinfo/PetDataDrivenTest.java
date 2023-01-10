package com.petstore.petstoreinfo;

import com.petstore.testbase.TestBase;
import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import net.thucydides.junit.annotations.Concurrent;
import net.thucydides.junit.annotations.UseTestDataFrom;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom("src/test/java/resources/testdata/petinfo.csv")
@Concurrent(threads = "2x")
public class PetDataDrivenTest extends TestBase {

    static int id;
    static String name;
    static String status;

    @Steps
    PetSteps petSteps;


    @Title("Data driven test for adding multiple pets to the application")
    @Test
    public void createMultiplePets() {

        HashMap<Object, Object> newCategory = new HashMap<>();
        newCategory.put("name", "Dog");
        newCategory.put("id", 2);

        List<Object> photoUrl = new ArrayList<>();
        photoUrl.add("https://www.google.com/url?sa=i&url=https%3A%2F%2Fcatastic.pet%2Fcat-breeds%2F11-fun-facts-about-tabby-cat%2F&psig=AOvVaw0tNqe9Q6z1VZOFGGguOVWP&ust=1672427102352000&source=images&cd=vfe&ved=0CA8QjRxqFwoTCOjW9szCn_wCFQAAAAAdAAAAABAJ");


        List<HashMap<Object, Object>> tagList = new ArrayList<>();
        HashMap<Object, Object> tagHash = new HashMap<>();
        tagHash.put("id", 1);
        tagHash.put("name", "Domesticated");
        tagList.add(tagHash);


        petSteps.createDataForNewPet(id, newCategory, name, photoUrl, tagList, status);


    }

}
