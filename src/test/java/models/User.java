package models;

import net.datafaker.Faker;

public record User (
    String firstname,
    String lastname,
    String zipcode
) {

    public static User generarUsuario() {
        final var faker = new Faker();
        final var firstname = faker.name().firstName();
        final var lastname = faker.name().lastName();
        final var zipcode = faker.address().zipCode();
        return new User(firstname,lastname,zipcode);
    }
}

