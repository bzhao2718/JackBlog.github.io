package com.springInAction.tacoCloud.web;

import com.springInAction.tacoCloud.domain.tacos.Ingredient;
import com.springInAction.tacoCloud.domain.tacos.Ingredient.IngredientType;
import com.springInAction.tacoCloud.domain.tacos.Taco;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author BoZhao
 */
@Slf4j
@Controller
@RequestMapping("/design")
@SessionAttributes("tacoOrder")
public class DesignTacoController
{
    /**
     * The lombok annotation @Slf4j has the same effect as
     * //    private static final org.slf4j.Logger log =
     *          org.slf4j.LoggerFactory.getLogger(DesignTacoController.class);
     */

    /**
     * @Controller serves to identify this class as a controller and to mark
     * it as a candidate for component scanning, so that Spring
     * will discover it and automatically create an instance of
     * DesignTacoController as a bean in the Spring application context.
     * @RequestMapping annotation, when applied at teh class level, specifies
     * the kind of requests that this controller handles.
     * In this case, it specifies that DesignTacoController will handle requests
     * whose path begins with /design
     * @GetMapping, paired witht eh class level @RequestMapping, specifies that when
     * an HTTP GET request is received for /design, showDesignForm() will be called to
     * handle the request. it returns a String value of "design", which is the
     * logical name of the view that will be used to render the model to the browser.
     * Model is an object that ferries data between a controller and whatever
     * view is charged with rendering that data. Ultimately, data that's placed
     * in Model attributes is copied into the servlet request attributes, where the view
     * can find them and use them to render a page in the user's browser.
     */
// the <form> doesn't declare an action attribute. This means that when the
    // form is submitted, the browser will gather up all the data in the form
    //and send it to the server in an HTTP POST request to the same path for which a
    // GET request displayedd the form: the /design path


    @GetMapping
    public String showDesignForm(Model model)
    {
        model.addAttribute("taco",new Taco());
        return "design";
    }
    //When the form is submitted, the fields in the form are bound to properties of
    // a Taco object, that's passed as a parameter into processtaco()

    @PostMapping
    public String processTaco(Taco taco)
    {
        //Save the taco
        log.info("Processing tacl: "+taco);

        return "redirect: /orders/current";
        //redirect indicating that this is a redict view.
        //more specifically, it indicates that after processTaco()
        // completes, the user's browser shoudl be redirected to the
        // relative path /orders/current
    }


    @ModelAttribute
    public void addIngredientsToModel(Model model)
    {
        List<Ingredient> ingredients = Arrays.asList(
                new Ingredient("COTO", "Corn Tortilla", IngredientType.WRAP),
                new Ingredient("GRBF", "Ground Beef", IngredientType.PROTEIN),
                new Ingredient("CARN", "Carnitas", IngredientType.PROTEIN),
                new Ingredient("TMTO", "Diced Tomatoes", IngredientType.VEGGIES),
                new Ingredient("LETC", "Lettuce", IngredientType.VEGGIES),
                new Ingredient("CHED", "Cheddar", IngredientType.CHEESE),
                new Ingredient("JACK", "Monterrey Jack", IngredientType.CHEESE),
                new Ingredient("SLSA", "Salsa", IngredientType.SAUCE),
                new Ingredient("SRCR", "Sour Cream", IngredientType.SAUCE)
        );
        IngredientType[] types = IngredientType.values();
        for(IngredientType type: types)
        {
            model.addAttribute(type.toString().toLowerCase(),filterByType(ingredients, type));
        }
        log.info("Added {} ingredients", ingredients.size());
    }


    private Iterable<Ingredient> filterByType(List<Ingredient> ingredients, IngredientType type)
    {
        return ingredients.stream()
                .filter(ingredient -> ingredient.getType().equals(type))
                .collect(Collectors.toList());
    }
}
