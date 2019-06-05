package com.giit.www.entity;

public class Book {
    String book_Title;
    String isbn;
    String date_Of_Printing;
    String author;
    String press;
    String category;
    Short unit_Price;

    @Override
    public String toString() {
        return "Book{" +
                "book_Title='" + book_Title + '\'' +
                ", isbn='" + isbn + '\'' +
                ", date_Of_Printing='" + date_Of_Printing + '\'' +
                ", author='" + author + '\'' +
                ", press='" + press + '\'' +
                ", category='" + category + '\'' +
                ", unit_Price=" + unit_Price +
                '}';
    }

    public String getBook_Title() {
        return book_Title;
    }

    public void setBook_Title(String book_Title) {
        this.book_Title = book_Title;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getDate_Of_Printing() {
        return date_Of_Printing;
    }

    public void setDate_Of_Printing(String date_Of_Printing) {
        this.date_Of_Printing = date_Of_Printing;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPress() {
        return press;
    }

    public void setPress(String press) {
        this.press = press;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Short getUnit_Price() {
        return unit_Price;
    }

    public void setUnit_Price(Short unit_Price) {
        this.unit_Price = unit_Price;
    }
}
