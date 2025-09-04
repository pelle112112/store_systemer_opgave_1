import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.lang.syntax.ArchRuleDefinition;
import org.junit.jupiter.api.Test;

public class SocialLayeringTest {

    private final JavaClasses classes = new ClassFileImporter().importPackages("soft2.social");

    @Test
    void socialFacade_should_only_depend_on_controllers() {
        ArchRuleDefinition.classes()
                .that().resideInAPackage("soft2.social.socialFacade..")
                .should().onlyDependOnClassesThat()
                .resideInAnyPackage(
                        "soft2.social.controller..",
                        "java.."
                ).check(classes);
    }

    @Test
    void socialControllers_should_only_depend_on_services() {
        ArchRuleDefinition.classes()
                .that().resideInAPackage("soft2.social.controller..")
                .should().onlyDependOnClassesThat()
                .resideInAnyPackage(
                        "soft2.social.service..",
                        "java.."
                ).check(classes);
    }

    @Test
    void socialServices_should_only_depend_on_repositoryFacades() {
        ArchRuleDefinition.classes()
                .that().resideInAPackage("soft2.social.service..")
                .should().onlyDependOnClassesThat()
                .resideInAnyPackage(
                        "soft2.social.repositoryFacade..",
                        "java.."
                ).check(classes);
    }

    @Test
    void socialRepositoryFacades_should_only_depend_on_repositories() {
        ArchRuleDefinition.classes()
                .that().resideInAPackage("soft2.social.repositoryFacade..")
                .should().onlyDependOnClassesThat()
                .resideInAnyPackage(
                        "soft2.social.repository..",
                        "java.."
                ).check(classes);
    }
}
