package com.bookshelf.models;

import java.util.Objects;

public class Book {
    private String bookName;
    private String isbn;
    private String author;
    private String bookDesc;
    private double bookPrice;

    public Book(String bookName, String isbn, String author, String bookDesc, double bookPrice) {
        this.bookName = bookName;
        this.isbn = isbn;
        this.author = author;
        this.bookDesc = bookDesc;
        this.bookPrice = bookPrice;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getBookDesc() {
        return bookDesc;
    }

    public void setBookDesc(String bookDesc) {
        this.bookDesc = bookDesc;
    }

    public double getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(double bookPrice) {
        this.bookPrice = bookPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Double.compare(book.bookPrice, bookPrice) == 0 &&
                 Objects.equals(bookName, book.bookName) &&
                 Objects.equals(isbn, book.isbn) &&
                 Objects.equals(author, book.author) &&
                 Objects.equals(bookDesc, book.bookDesc);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookName, isbn, author, bookDesc, bookPrice);
    }

    @Override
    public String toString() {
        return "Book{" +
                 "bookName='" + bookName + '\'' +
                 ", isbn='" + isbn + '\'' +
                 ", author='" + author + '\'' +
                 ", bookDesc='" + bookDesc + '\'' +
                 ", bookPrice=" + bookPrice +
                 '}';
    }
}
