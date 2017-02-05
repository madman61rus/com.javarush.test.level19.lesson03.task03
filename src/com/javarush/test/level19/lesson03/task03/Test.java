package com.javarush.test.level19.lesson03.task03;

/**
 * Created by vkompaniec on 06.02.17.
 */
public class Test
{
    private static class TestCustomer implements Solution.Customer{

        private String companyName;
        private String countryName;

        public TestCustomer(String companyName,String countryName)
        {
            this.companyName = companyName;
            this.countryName = countryName;
        }
        @Override
        public String getCompanyName()
        {
            return companyName;
        }

        @Override
        public String getCountryName()
        {
            return countryName;
        }
    }

    private static class TestContact implements Solution.Contact{

        private String name;
        private String phoneNumber;

        public TestContact(String name, String phoneNumber)
        {
            this.name = name;
            this.phoneNumber = phoneNumber;
        }

        @Override
        public String getName()
        {
            return name;
        }

        @Override
        public String getPhoneNumber()
        {
            return phoneNumber;
        }
    }

    public static void main(String[] args)
    {
        TestCustomer testCustomer = new TestCustomer("JavaRush Ltd.", "Ukraine");
        TestContact testContact = new TestContact("Ivanov, Ivan", "+38(050)123-45-67");
        Solution.IncomeDataAdapter incomeDataAdapter = new Solution.IncomeDataAdapter(testCustomer,testContact);
        System.out.println(incomeDataAdapter.getCountryCode());
        System.out.println(incomeDataAdapter.getCompany());
        System.out.println(incomeDataAdapter.getContactFirstName());
        System.out.println(incomeDataAdapter.getContactLastName());
        System.out.println(incomeDataAdapter.getCountryPhoneCode());
        System.out.println(incomeDataAdapter.getPhoneNumber());
    }
}
