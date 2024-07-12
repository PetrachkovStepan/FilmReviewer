package com.example.demo;

import java.util.ArrayList;

public class BookList {
    private ArrayList<User> users = new ArrayList<>();

    public BookList() {
    }

    public ArrayList<User> getBooks() {
        return users;
    }

    void add(User user){
        users.add(user);
    }
    void addAll(BookList books){
        books.addAll(books);
    }
    int length(){
        return this.length();
    }
}
