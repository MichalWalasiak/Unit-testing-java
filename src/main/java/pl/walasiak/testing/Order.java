package pl.walasiak.testing;

import java.util.ArrayList;
import java.util.List;

class Order {

    private List<Meal> meals = new ArrayList<>();

    public void addMealToOrder(Meal meal){
        meals.add(meal);
    }

    public void removeMealFromOrder(Meal meal){
        meals.remove(meal);
    }

    public List<Meal> getMeals() {
        return meals;
    }

    public void cancel(){
        this.meals.clear();
    }

    @Override
    public String toString() {
        return "Order{" +
                "meals=" + meals +
                '}';
    }
}
