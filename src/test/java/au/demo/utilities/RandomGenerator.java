package au.demo.utilities;

import com.devskiller.jfairy.Fairy;
import com.devskiller.jfairy.producer.person.Person;
import java.util.*;

public class RandomGenerator {

    public static Object getFormData(String sectionName) {
        HashMap<String, String> formData = new HashMap<>();
        switch(sectionName.toUpperCase()){
            case "CONTACT-US": return getContactUsFormData();
        }
        return formData;
    }

    public static Object getContactUsFormData(){
        Fairy randomizer = Fairy.create();
        Person contactPerson = randomizer.person();
        HashMap<String, String> contactUsFormData = new HashMap<>();
        contactUsFormData.put("FirstName", contactPerson.getFirstName());
        contactUsFormData.put("LastName", contactPerson.getLastName());
        contactUsFormData.put("Email", contactPerson.getEmail());
        contactUsFormData.put("Phone", contactPerson.getTelephoneNumber() );
        contactUsFormData.put("WebsiteURL", contactPerson.getEmail());
        contactUsFormData.put("Company", contactPerson.getCompany().getName());
        contactUsFormData.put("EnquiryReason", getRandomReasonForEnquiry());
        return contactUsFormData;
    }

    public static String getRandomReasonForEnquiry(){
        String reason = "";
        switch (getRandomNumberInRange(1,2)){
            case 1: reason = "Support"; break;
            case 2: reason = "Accounts"; break;
        }
        return reason;
    }

    private static int getRandomNumberInRange(int min, int max) {
        if (min >= max) {
            throw new IllegalArgumentException("Max must be greater than Min");
        }
        return (int)(Math.random() * ((max - min) + 1)) + min;
    }
}
