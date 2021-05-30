package com.Product_Manage.model;


    import java.io.Serializable;

    /**
     *
     * @author Diep
     */
    public class Product implements Serializable{
       String name, email;

        public Product(String name, String email) {
            this.name = name;
            this.email = email;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public Product() {
        }
    }

