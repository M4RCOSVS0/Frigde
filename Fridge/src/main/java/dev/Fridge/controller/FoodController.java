package dev.Fridge.controller;
import dev.Fridge.model.Food;
import dev.Fridge.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/food")
public class FoodController {

    //@Autowired
    //injeção de dependência
    private final FoodService foodService;

    public FoodController(FoodService foodService) {
        this.foodService = foodService;
    }

    //GET
    @GetMapping
    public List<Food> getAll() {
        return foodService.getAll();
    }

    //GET BY ID
    @GetMapping("/{id}")
    public ResponseEntity<Food> getById(@PathVariable long id) {
        Food food = foodService.getById(id);

        if (food != null) {
            return ResponseEntity.ok(food); //200
        }else{
            return ResponseEntity.notFound().build(); //404
        }

    }

    //POST
    @PostMapping
    public Food create(@RequestBody Food food) {
        return foodService.save(food);
    }

    //PUT
    @PutMapping
    public Food update(@RequestBody Food food) {
        return foodService.save(food);
    }

    //DELETE
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        foodService.delete(id);
    }
}
