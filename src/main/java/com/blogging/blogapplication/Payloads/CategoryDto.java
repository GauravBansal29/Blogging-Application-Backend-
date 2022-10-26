package com.blogging.blogapplication.Payloads;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDto {

    @Size(min = 3, message = "Category names must be of atleast 3 size")
    private String name;
    @NotEmpty(message = "The description section can't be empty")
    private String desc;
}
