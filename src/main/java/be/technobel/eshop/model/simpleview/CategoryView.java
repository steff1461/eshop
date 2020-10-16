package be.technobel.eshop.model.simpleview;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CategoryView {

    private String name;
    private Long id;

    public Long getId() {
        return id;
    }

    public CategoryView setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public CategoryView setName(String name) {
        this.name = name;
        return this;
    }
}
