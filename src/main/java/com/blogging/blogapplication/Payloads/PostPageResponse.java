package com.blogging.blogapplication.Payloads;

import java.util.List;

import lombok.*;

// this is made to implement pagenation in the Spring Boot app
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PostPageResponse {

    private List<PostDto> pagecontent;
    private int pageNumber;
    private int pageSize;
    private int totalpages;
    private Long totalElements;
    private Boolean isLast;
}
