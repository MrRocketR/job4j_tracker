package ru.job4j.tracker.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Singular;
import lombok.ToString;

import java.util.List;

@ToString
@Builder(builderMethodName = "startBuild")
@Getter
public class Permission {
    private int id;
    private String name;
    @Singular("addRule")
    private List<String> rules;
}
