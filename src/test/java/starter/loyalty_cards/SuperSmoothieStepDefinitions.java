package starter.loyalty_cards;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class SuperSmoothieStepDefinitions {

    private DrinkCatalog drinkCatalog = new DrinkCatalog();
    private SuperSmoothiesSchema superSmoothiesSchema = new SuperSmoothiesSchema(drinkCatalog);
    private MorningFreshnessMember alex;

    @Given("The following drink categories:")
    public void the_following_drink_categories(List<Map<String,String>> drinkCategories) {
        drinkCategories.stream().forEach(
                drinkCategory -> {
                    String drink = drinkCategory.get("Drink");
                    String category = drinkCategory.get("Category");
                    Integer points = Integer.parseInt(drinkCategory.get("Points"));
                    
                    drinkCatalog.addDrink(drink, category);
                    superSmoothiesSchema.setPointsPerCategory(category,points);
                }
                );

    }

    @Given("{} is a Morning Freshness Member")
    public void alex_is_a_Morning_Freshness_Member(String name) {
        alex = new MorningFreshnessMember(name, superSmoothiesSchema);

    }

    @When("^(.*) purchases (\\d+) (.*) drinks?")
    public void alex_purchases_Triple_Berry_Blend_drinks(String name,
                                                         Integer amount,
                                                         String drink) {
        alex.orders(amount,drink);

    }
    @Then("He should earn {int} points")
    public void he_should_earn_points(Integer expectedPoints) {
        assertThat(alex.getPoints()).isEqualTo(expectedPoints);

    }

}
