package net.serenitybdd.demos.todos.screenplay.features.issues;

import net.serenitybdd.demos.todos.screenplay.tasks.Start;
import net.serenitybdd.demos.todos.screenplay.tasks.StartInitiallySilently;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.WithTag;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import static net.serenitybdd.screenplay.GivenWhenThen.givenThat;

@RunWith(SerenityRunner.class)
@WithTag("issue:issue-1523")
public class Issue1523 {

    private Actor james = Actor.named("James");

    @Managed
    private WebDriver hisBrowser;

    @Before
    public void jamesCanBrowseTheWeb() {
        james.can(BrowseTheWeb.with(hisBrowser));
    }

    @Test
    public void reproduces_problem_with_non_reported_tasks() {
        givenThat(james).wasAbleTo(StartInitiallySilently.withATodoListContaining("Walk the dog", "Put out the garbage"));

    }

    @Test
    public void same_test_but_without_silent_top_level_task() {
        givenThat(james).wasAbleTo(Start.withATodoListContaining("Walk the dog", "Put out the garbage"));

    }
}