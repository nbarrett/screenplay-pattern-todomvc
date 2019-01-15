package net.serenitybdd.demos.todos.screenplay.tasks;

import net.serenitybdd.markers.IsSilent;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;

import java.util.List;

import static com.google.common.collect.Lists.newArrayList;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class StartInitiallySilently implements Interaction, IsSilent {

    private final List<String> items;

    public StartInitiallySilently(List<String> items) {
        this.items = items;
    }

    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
            Start.withATodoListContaining(items));
    }

    public static Interaction withATodoListContaining(String... items) {
        return instrumented(StartInitiallySilently.class, newArrayList(items));

    }
}