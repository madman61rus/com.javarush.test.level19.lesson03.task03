package com.javarush.test.level19.lesson03.task03;

/* Адаптация нескольких интерфейсов
Адаптировать IncomeData к Customer и Contact.
Классом-адаптером является IncomeDataAdapter.
Инициализируйте countries перед началом выполнения программы. Соответствие кода страны и названия:
UA Ukraine
RU Russia
CA Canada
Дополнить телефонный номер нулями до 10 цифр при необходимости (смотри примеры)
Обратите внимание на формат вывода фамилии и имени человека
*/

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static Map<String, String> countries = new HashMap<String, String>();

    static {
        countries.put("UA", "Ukraine" );
        countries.put("RU", "Russia" );
        countries.put("CA", "Canada" );
    }

    public static class IncomeDataAdapter implements IncomeData {

        private Customer customer ;
        private Contact contact ;

        public IncomeDataAdapter(Customer customer, Contact contact){
            this.contact = contact;
            this.customer = customer;
        }

        @Override
        public String getCountryCode()
        {
            for (Map.Entry<String,String> entry : countries.entrySet())
            {
                if (entry.getValue().equals(customer.getCountryName()))
                {
                    return entry.getKey();
                }
            }
            return null;
        }

        @Override
        public String getCompany()
        {
            return customer.getCompanyName();
        }

        @Override
        public String getContactFirstName()
        {
            String firstName = contact.getName().split(", ") [1];
            return firstName;
        }

        @Override
        public String getContactLastName()
        {
            String lastName = contact.getName().split(", ") [0].trim();
            return lastName;
        }

        @Override
        public int getCountryPhoneCode()
        {
            Integer indexLast = contact.getPhoneNumber().indexOf((int) '(');
            String stringCode = contact.getPhoneNumber().substring(1,indexLast);
            return Integer.parseInt(stringCode);
        }

        @Override
        public int getPhoneNumber()
        {
            Integer indexFirst = contact.getPhoneNumber().indexOf((int) ')');
            String stringCode = contact.getPhoneNumber().substring(indexFirst+1,contact.getPhoneNumber().length());
            if (stringCode.length() < 10)
            {
                StringBuilder zeroBuilder = new StringBuilder();
                for (int i=0; i<10-stringCode.length();i++)
                {
                    zeroBuilder.append('0');
                }
                zeroBuilder.append(stringCode);
                return Integer.parseInt(zeroBuilder.toString().replace("-",""));
            }else {
                return Integer.parseInt(stringCode.replace("-",""));
            }

        }
    }

    public static interface IncomeData {
        String getCountryCode();        //example UA

        String getCompany();            //example JavaRush Ltd.

        String getContactFirstName();   //example Ivan

        String getContactLastName();    //example Ivanov

        int getCountryPhoneCode();      //example 38

        int getPhoneNumber();           //example 501234567
    }

    public static interface Customer {
        String getCompanyName();        //example JavaRush Ltd.

        String getCountryName();        //example Ukraine
    }

    public static interface Contact {
        String getName();               //example Ivanov, Ivan

        String getPhoneNumber();        //example +38(050)123-45-67
    }
}