import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.lang.syntax.ArchRuleDefinition;
import org.junit.jupiter.api.Test;

public class MarketingLayeringTest {

    private final JavaClasses classes = new ClassFileImporter().importPackages("soft2.marketing");

    @Test
    void marketingFacade_should_only_depend_on_controllers(){
        ArchRuleDefinition.classes()
                .that().resideInAPackage("soft2.marketing.marketingFacade..")
                .should().onlyDependOnClassesThat()
                .resideInAnyPackage(
                        "soft2.marketing.controller..",
                        "java.."
                ).check(classes);
    }

    @Test
    void marketingControllers_should_only_depend_on_services(){
        ArchRuleDefinition.classes()
                .that().resideInAPackage("soft2.marketing.controller..")
                .should().onlyDependOnClassesThat()
                .resideInAnyPackage(
                        "soft2.marketing.service..",
                        "java.."
                ).check(classes);
    }

    @Test
    void marketingServices_should_only_depend_on_repositoryFacades(){
        ArchRuleDefinition.classes()
                .that().resideInAPackage("soft2.marketing.service..")
                .should().onlyDependOnClassesThat()
                .resideInAnyPackage(
                        "soft2.marketing.repositoryFacade..",
                        "java.."
                ).check(classes);
    }

    @Test
    void marketingRepositoryFacades_should_only_depend_on_repositories(){
        ArchRuleDefinition.classes()
                .that().resideInAPackage("soft2.marketing.repositoryFacade..")
                .should().onlyDependOnClassesThat()
                .resideInAnyPackage(
                        "soft2.marketing.repository..",
                        "java.."
                ).check(classes);
    }
}
