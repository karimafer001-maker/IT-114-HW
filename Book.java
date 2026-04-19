public class Book {

    private String title;
    private String author;
    private int totalPages;
    private int currentPage;

    public Book(String title, String author, int totalPages) {
        this.title = title;
        this.author = author;
        this.totalPages = totalPages;
        this.currentPage = 0;
    }

    public void readPages(int pages) {
        if (pages > 0) {
            currentPage += pages;
            if (currentPage > totalPages) {
                currentPage = totalPages;
            }
            System.out.println("Reading " + pages + " pages... Progress: " 
                               + String.format("%.1f", getProgress()) + "%");
        } else {
            System.out.println("Cannot read 0 or negative pages.");
        }
    }

    public double getProgress() {
        if (totalPages == 0) return 0.0;
        return (currentPage * 100.0) / totalPages;
    }

    public boolean isFinished() {
        return currentPage == totalPages;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    @Override
    public String toString() {
        return "'" + title + "' by " + author + 
               " (" + currentPage + "/" + totalPages + 
               ", " + String.format("%.1f", getProgress()) + "%)";
    }

    public static void main(String[] args) {
        
        Book book1 = new Book("Nice Guy", "Unknown Author", 250);
        Book book2 = new Book("Cool Guy", "Unknown Author", 180);

        System.out.print("Created Books:");
        System.out.print(book1);
        System.out.print(book2);
        System.out.print();

        book1.readPages(70);
        book2.readPages(150);

        System.out.print("\nAfter reading some pages:");
        System.out.print(book1);
        System.out.print(book2);

        book1.readPages(200);

        System.out.print("\nFinal Status:");
        System.out.print(book1);
        System.out.print("Is Finished: " + book1.isFinished());
        
        System.out.print(book2);
        System.out.print("Is Finished: " + book2.isFinished());
    }
}
