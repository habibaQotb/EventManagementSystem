package com.example.eventmanagement;

public class Category {

    //attributes
    private String categoryName;
    private String categoryDescription;

    //constructors
    public Category(){
        Database.getCategories().add(this);
    }
    public Category(String categoryName, String categoryDescription){
        this.categoryName = categoryName;
        this.categoryDescription = categoryDescription;
        Database.getCategories().add(this);
    }

    //override toString
    @Override
    public String toString() {
        return "Category {" +
                "categoryName = '" + categoryName + '\'' +
                ", categoryDescription = '" + categoryDescription + '\'' +
                '}' + "\n";
    }

    //methods
    public String getCategoryName(){
        return categoryName;
    }

    public String getCategoryDescription(){
        return categoryDescription;
    }

    public void setCategoryName(String newCategoryName){
        categoryName = newCategoryName;
    }

    public void setCategoryDescription(String newCategoryDescription){
        categoryDescription = newCategoryDescription;
    }
}
