package be.technobel.eshop.model.simpleview;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CategoryView {

    private String name;

    public String getName() {
        return name;
    }

    public CategoryView setName(String name) {
        this.name = name;
        return this;
    }
}
