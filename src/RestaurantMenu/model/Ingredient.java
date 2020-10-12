package RestaurantMenu.model;

public class Ingredient {
    protected String name;
    protected Restriction restriction;

    public Ingredient(String name, Restriction restriction) {
        this.name = name;
        this.restriction = restriction;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Restriction getRestriction() {
        return restriction;
    }

    public void setRestriction(Restriction restriction) {
        this.restriction = restriction;
    }
}
