package dev.Fridge.service;

import dev.Fridge.model.Food;
import dev.Fridge.rository.FoodRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class FoodService {

    private final FoodRepository foodRepository;

    public FoodService(FoodRepository foodRepository) {
        this.foodRepository = foodRepository;
    }

    //Listar
    public List<Food> getAll() {
        return foodRepository.findAll();
    }

    //Listar por ID
    public Food getById(Long id) {
        return foodRepository.findById(id).orElse(null);
    }

    //criar
    public Food save(Food food) {
        return foodRepository.save(food);
    }

    //Editar
    public Food update(Food food) {
        return foodRepository.save(food);
    }


    //DELETAR
    public void delete(Long id) {
        foodRepository.deleteById(id);
    }


}
