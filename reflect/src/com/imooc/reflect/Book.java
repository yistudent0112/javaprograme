package com.imooc.reflect;

public class Book {
private int BookId;
private String BookName;
public int BookPrice;
public Book() {
	
}
public Book(int bookId, String bookName, int bookPrice) {
	super();
	BookId = bookId;
	BookName = bookName;
	BookPrice = bookPrice;
}
@Override
public String toString() {
	return "Book [BookId=" + BookId + ", BookName=" + BookName + ", BookPrice=" + BookPrice + "]";
}

}
