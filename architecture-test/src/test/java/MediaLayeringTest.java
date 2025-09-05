import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.lang.syntax.ArchRuleDefinition;
import org.junit.jupiter.api.Test;

public class MediaLayeringTest {

    private final JavaClasses classes = new ClassFileImporter().importPackages("soft2.media");

    @Test
    void mediaFacade_should_only_depend_on_controllers() {
        ArchRuleDefinition.classes()
                .that().resideInAPackage("soft2.media.mediaFacade..")
                .should().onlyDependOnClassesThat()
                .resideInAnyPackage(
                        "soft2.media.controller..",
                        "java.."
                ).check(classes);
    }

    @Test
    void mediaControllers_should_only_depend_on_services() {
        ArchRuleDefinition.classes()
                .that().resideInAPackage("soft2.media.controller..")
                .should().onlyDependOnClassesThat()
                .resideInAnyPackage(
                        "soft2.media.service..",
                        "java.."
                ).check(classes);
    }

    @Test
    void mediaServices_should_only_depend_on_repositoryFacades() {
        ArchRuleDefinition.classes()
                .that().resideInAPackage("soft2.media.service..")
                .should().onlyDependOnClassesThat()
                .resideInAnyPackage(
                        "soft2.media.repositoryFacade..",
                        "java.."
                ).check(classes);
    }

    @Test
    void mediaRepositoryFacades_should_only_depend_on_repositories() {
        ArchRuleDefinition.classes()
                .that().resideInAPackage("soft2.media.repositoryFacade..")
                .should().onlyDependOnClassesThat()
                .resideInAnyPackage(
                        "soft2.media.repository..",
                        "java.."
                ).check(classes);
    }
}
