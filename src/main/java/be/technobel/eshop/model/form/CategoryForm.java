package be.technobel.eshop.model.form;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CategoryForm {

    private String name;

    public String getName() {
        return name;
    }

    public CategoryForm setName(String name) {
        this.name = name;
        return this;
    }
}
