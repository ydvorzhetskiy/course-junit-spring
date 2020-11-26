package edu.spring.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Класс Person")
class PersonTest {

    @DisplayName("Должен корректно создаваться")
    @Test
    void getId() {
        Person person = new Person(12, "Ivan");
        assertThat(person.getId()).isEqualTo(12);
    }
}
