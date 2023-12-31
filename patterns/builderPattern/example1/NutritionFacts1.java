package patterns.builderPattern.example1;

// Telescoping constructor pattern - does not scale well!
public class NutritionFacts1 {
    private final int servingSize; // (mL) required
    private final int servings; // (per container) required
    private final int calories; // (per serving) optional
    private final int fat; // (g/serving) optional
    private final int sodium; // (mg/serving) optional
    private final int carbohydrate; // (g/serving) optional

    public NutritionFacts1(int servingSize, int servings) {
        this(servingSize, servings, 0);
    }

    public NutritionFacts1(int servingSize, int servings,
            int calories) {
        this(servingSize, servings, calories, 0);
    }

    public NutritionFacts1(int servingSize, int servings,
            int calories, int fat) {
        this(servingSize, servings, calories, fat, 0);
    }

    public NutritionFacts1(int servingSize, int servings,
            int calories, int fat, int sodium) {
        this(servingSize, servings, calories, fat, sodium, 0);
    }

    public NutritionFacts1(int servingSize, int servings,
            int calories, int fat, int sodium, int carbohydrate) {
        this.servingSize = servingSize;
        this.servings = servings;
        this.calories = calories;
        this.fat = fat;
        this.sodium = sodium;
        this.carbohydrate = carbohydrate;
    }

    

    @Override
    public String toString() {
        return "NutritionFacts1 [servingSize=" + servingSize + ", servings=" + servings + ", calories=" + calories
                + ", fat=" + fat + ", sodium=" + sodium + ", carbohydrate=" + carbohydrate + "]";
    }

    public static void main(String[] args) {
        NutritionFacts1 cocaCola = new NutritionFacts1(240, 8, 100, 0, 35, 27);      
        System.out.println(cocaCola);
    }
}
