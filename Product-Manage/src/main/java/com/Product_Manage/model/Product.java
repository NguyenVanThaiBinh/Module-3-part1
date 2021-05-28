package com.Product_Manage.model;


    import java.io.Serializable;

    /**
     *
     * @author Diep
     */
    public class Product implements Serializable{
        String name, category, description;
        float price;

        public Product() {
        }

        public Product(String name, String category, String description, float price) {
            this.name = name;
            this.category = category;
            this.description = description;
            this.price = price;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getCategory() {
            return category;
        }

        public void setCategory(String category) {
            this.category = category;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public float getPrice() {
            return price;
        }

        public void setPrice(float price) {
            this.price = price;
        }

        @Override
        public String toString() {
            return "Product{" + "name=" + name + ", category=" + category + ", description=" + description + ", price=" + price + '}';
        }


    }

