package ru.job4j.tracker.model;

import lombok.*;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@RequiredArgsConstructor
public class Category {

    @Getter
    @EqualsAndHashCode.Include
    @NonNull
    private int id;
    @Getter
    @Setter
    private String name;
}
