package Model;

public class Category {
    private final String categoryName;

    public Category() {
        this.categoryName = null;
    }

    public Category(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryName() {
        return categoryName;
    }
}
