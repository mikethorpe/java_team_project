import db.DBHelper;
import models.Author;

public class Runner {

    public static void main(String[] args) {

        Author author1 = new Author("Mike");
        DBHelper.save(author1);
        Author author2 = new Author("Molly");
        DBHelper.save(author2);
    }
}
