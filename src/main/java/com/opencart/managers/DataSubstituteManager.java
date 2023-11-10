package com.opencart.managers;

import com.opencart.context.CONTEXT;
import com.opencart.context.ScenarioContext;

public class DataSubstituteManager {
    public static String substituteString(String value) {
        switch (value.toUpperCase()) {
            case "RANDOM":
                return RandomDataManager.generateLastName();
            case "RANDOMEMAIL":
                String email = RandomDataManager.generateRandomEmail();
                ScenarioContext.getInstance().addToStorageContext(CONTEXT.EMAIL, email);
                return email;
            case "RANDOMFIRSTNAME":
                return RandomDataManager.generateFirstName();
            case "RANDOMPASSWORD":
                String password = RandomDataManager.generatePassword();
                ScenarioContext.getInstance().addToStorageContext(CONTEXT.PASSWORD, password);
                return password;
        }
        return value;
    }
}
