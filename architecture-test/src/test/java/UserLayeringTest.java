import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.lang.syntax.ArchRuleDefinition;
import org.junit.jupiter.api.Test;

public class UserLayeringTest {

    private final JavaClasses classes = new ClassFileImporter().importPackages("soft2.user");

    @Test
    void userFacade_should_only_depend_on_controllers() {
        ArchRuleDefinition.classes()
                .that().resideInAPackage("soft2.user.userFacade..")
                .should().onlyDependOnClassesThat()
                .resideInAnyPackage(
                        "soft2.user.controller..",
                        "java.."
                ).check(classes);
    }

    @Test
    void userControllers_should_only_depend_on_services() {
        ArchRuleDefinition.classes()
                .that().resideInAPackage("soft2.user.controller..")
                .should().onlyDependOnClassesThat()
                .resideInAnyPackage(
                        "soft2.user.service..",
                        "java.."
                ).check(classes);
    }

    @Test
    void userServices_should_only_depend_on_repositoryFacades() {
        ArchRuleDefinition.classes()
                .that().resideInAPackage("soft2.user.service..")
                .should().onlyDependOnClassesThat()
                .resideInAnyPackage(
                        "soft2.user.repositoryFacade..",
                        "java.."
                ).check(classes);
    }

    @Test
    void userRepositoryFacades_should_only_depend_on_repositories() {
        ArchRuleDefinition.classes()
                .that().resideInAPackage("soft2.user.repositoryFacade..")
                .should().onlyDependOnClassesThat()
                .resideInAnyPackage(
                        "soft2.user.repository..",
                        "java.."
                ).check(classes);
    }
}
