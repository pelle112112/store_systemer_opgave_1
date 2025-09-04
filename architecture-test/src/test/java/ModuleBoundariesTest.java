import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.lang.ArchRule;
import com.tngtech.archunit.lang.syntax.ArchRuleDefinition;
import org.junit.jupiter.api.Test;

class ModuleBoundariesTest {

    private final JavaClasses classes = new ClassFileImporter().importPackages("soft2");

    @Test
    void bootApp_should_only_access_facades_of_other_modules() {
        ArchRule rule = ArchRuleDefinition.classes()
                .that().resideInAPackage("soft2.bootapp..")
                .should().onlyAccessClassesThat()
                .resideInAnyPackage(
                        "soft2.bootapp..",
                        "soft2.user.userFacade..",
                        "soft2.marketing.marketingFacade..",
                        "soft2.media.mediaFacade..",
                        "soft2.social.socialFacade..",
                        "java..",
                        "io.javalin.."
                );

        rule.check(classes);
    }
}
