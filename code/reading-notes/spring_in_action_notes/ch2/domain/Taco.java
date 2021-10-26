package com.springInAction.tacoCloud.domain.tacos;

import lombok.Data;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

/**
 * @author BoZhao
 */
@Data
public class Taco
{
    @NotNull
    @Size(min=5, message = "Name must be at least 5 characters long")
    private String name;
    
    @Size(min=1, message = "You must choost at least 1 ingredient")
    private List<Ingredient> ingredients;
}
