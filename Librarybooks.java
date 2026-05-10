public class Librarybooks {

    static class Book {
        private String title;
        private String author;
        private String isbn;
        private boolean isAvailable;

        public Book(String title, String author, String isbn) {
            this.title = title;
            this.author = author;
            this.isbn = isbn;
            this.isAvailable = true;
        }

        public void checkOut() {
            if (isAvailable) {
                isAvailable = false;
                System.out.print(title + " has been checked out.");
            } else {
                System.out.print(title + " is already checked out.");
            }
        }

        public void returnBook() {
            isAvailable = true;
            System.out.print(title + " has been returned.");
        }

        public String getDetails() {
            return title + " by " + author + " | ISBN: " + isbn + " | Available: " + isAvailable;
        }

        public String getTitle() {
            return title;
        }

        public boolean isAvailable() {
            return isAvailable;
        }
    }

    static class Member {
        private String name;
        private String memberId;
        private Book[] borrowedBooks;
        private int borrowCount;

        public Member(String name, String memberId) {
            this.name = name;
            this.memberId = memberId;
            this.borrowedBooks = new Book[3];   // max 3 books
            this.borrowCount = 0;
        }

        public void borrowBook(Book book) {
            if (borrowCount >= 3) {
                System.out.print(name + " cannot borrow more than 3 books.");
                return;
            }
            if (!book.isAvailable()) {
                System.out.print(book.getTitle() + " is not available.");
                return;
            }

            book.checkOut();
            borrowedBooks[borrowCount] = book;
            borrowCount++;
            System.out.print(name + " borrowed: " + book.getTitle());
        }

        public void returnBook(Book book) {
            for (int i = 0; i < borrowCount; i++) {
                if (borrowedBooks[i] == book) {
                    book.returnBook();
                    borrowedBooks[i] = borrowedBooks[borrowCount - 1];
                    borrowCount--;
                    System.out.print(name + " returned: " + book.getTitle());
                    return;
                }
            }
            System.out.println(name + " did not borrow " + book.getTitle());
        }

        public void listBorrowedBooks() {
            if (borrowCount == 0) {
                System.out.print(name + " has no borrowed books.");
            } else {
                System.out.print(name + "'s borrowed books:");
                for (int i = 0; i < borrowCount; i++) {
                    System.out.print("   - " + borrowedBooks[i].getTitle());
                }
            }
        }
    }

    public static void main(String[] args) {
        Book book1 = new Book("The", "Paul", "5007");
        Book book2 = new Book("1984", "Orwell", "1524935");
        Book book3 = new Book("Done", "Frankt", "172719");

        Member alice = new Member("Spaid", "Idk");
        Member bob = new Member("Aids", "idk");

        System.out.print("=== Library System ===\n");

        alice.borrowBook(book1);
        alice.borrowBook(book2);
        bob.borrowBook(book3);

        System.out.print("\nBorrowed Books:");
        alice.listBorrowedBooks();
        bob.listBorrowedBooks();

        System.out.print("\nReturning a book:");
        alice.returnBook(book1);

        System.out.print("\nUpdated list:");
        alice.listBorrowedBooks();
    }
}