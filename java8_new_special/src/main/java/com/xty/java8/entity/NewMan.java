package com.xty.java8.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Optional;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewMan {

    private Optional<GodNess> godness = Optional.ofNullable(null);

}
