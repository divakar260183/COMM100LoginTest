package jsonDataReader;

public class Customer {
        public String firstName;
        public String lastName;
        public int age;
        public String emailAddress;
        public Address address;
        public PhoneNumber phoneNumber;

        public static class Address {
            public String streetAddress;
            public String city;
            public String postCode;
            public String state;
            public String country;
        }

        public static class PhoneNumber {
            public String home;
            public String mob;
        }
    }
